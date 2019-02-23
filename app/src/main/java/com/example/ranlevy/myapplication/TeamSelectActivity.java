package com.example.ranlevy.myapplication;

import android.Manifest;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class TeamSelectActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    FirebaseDatabase database;
    DatabaseReference myRef;
    ListView listview;
    private SearchView searchView;
    private MenuItem searchMenuItem;
    TeamAdapter adapter;

    private static final String TEAMS_FILE_NAME = "Teams.txt";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_select);

        this.listview = (ListView) findViewById(R.id.listview);
        this.listview.setTextFilterEnabled(true);

        final ArrayList<Team> list = new ArrayList<Team>();
        if(!readTeamsFromFile(list)) {
            Log.d("Teams activity","Reading from firebase");
            readTeamsFromFirebase(list);
            writeTeamsToFile(list);
        }
        Log.d("Teams activity","list len:" +list.size());

        updateListView(list);

        this.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 1
                Team selectedTeam = (Team) list.get(position);

                Log.d("TEAM", selectedTeam.Name.toString());

                if (searchView.isShown()) {
                    searchMenuItem.collapseActionView();
                    searchView.setQuery("", false);
                }

                autoGame(selectedTeam.Number,selectedTeam.Name);


            }

        });


    }

    private void readTeamsFromFirebase(final ArrayList<Team> list) {
        this.database = FirebaseDatabase.getInstance();
        this.myRef = database.getReference("Teams");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot teamSnapshot : dataSnapshot.getChildren()) {
//                    Team team = teamSnapshot.getValue(Team.class);
                    Team team = new Team();
                    String name = (String) teamSnapshot.child("Name").getValue();
                    long number = (Long) teamSnapshot.child("Number").getValue();

                    team.Name = name;
                    team.Number = number;
                    list.add(team);
                }
                updateListView(list);
                writeTeamsToFile(list);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

    }

    public void writeTeamsToFile(ArrayList<Team> data) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(getApplicationContext().openFileOutput(TEAMS_FILE_NAME, Context.MODE_PRIVATE));
            StringBuilder teamStrBuilder = new StringBuilder();
            for (Team t : data) {
                Log.d("Teams activity","writing team " + t.Number);
                teamStrBuilder.append(t.Number + "," + t.Name + "\n");
            }

            outputStreamWriter.write(teamStrBuilder.toString());
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private boolean readTeamsFromFile(final ArrayList<Team> list) {


        try {
            InputStream inputStream = getApplicationContext().openFileInput(TEAMS_FILE_NAME);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";

                while ((receiveString = bufferedReader.readLine()) != null) {
                    String[] parts = receiveString.split(",");
                    list.add(new Team(Long.parseLong(parts[0]), parts[1]));
                }

                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("Team select activity", "File not found: " + e.toString());
            return false;
        } catch (IOException e) {
            Log.e("Team select activity", "Can not read file: " + e.toString());
            return false;
        }
        return true;
    }

    public void updateListView(ArrayList<Team> list) {
//        ArrayAdapter<Team> adapter = new ArrayAdapter<Team>(this, android.R.layout.simple_list_item_1, list);
        this.adapter = new TeamAdapter(this, list);

        this.listview.setAdapter(adapter);
    }

    public void autoGame(Long teamNumber,String teamName) {
        Intent intent = new Intent(this, AutoGame.class);
        intent.putExtra("team_number", teamNumber);
        intent.putExtra("team_name",teamName);
        intent.putExtra("is_auto",true);
        intent.putExtras(getIntent());
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);
        searchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) searchMenuItem.getActionView();

        searchView.setSearchableInfo(searchManager.
                getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        this.adapter.getFilter().filter(s);

        return true;
    }


    public class TeamAdapter extends BaseAdapter implements Filterable {
        private Context context;
        private LayoutInflater layoutInflater;
        private ArrayList<Team> dataSource;
        private ArrayList<Team> filteredList;
        private TeamFilter teamFilter;

        public TeamAdapter(Context _context, ArrayList<Team> teams) {
            context = _context;
            dataSource = teams;
            filteredList = teams;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        //1
        @Override
        public int getCount() {
            return filteredList.size();
        }

        //2
        @Override
        public Object getItem(int position) {
            return filteredList.get(position);
        }

        //3
        @Override
        public long getItemId(int position) {
            return position;
        }

        //4
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get view for row item
            View rowView = layoutInflater.inflate(R.layout.list_item_team, parent, false);

            TextView teamName = (TextView) rowView.findViewById(R.id.Name);
            TextView teamNumber = (TextView) rowView.findViewById(R.id.Number);

            Team team = (Team) getItem(position);

            teamName.setText(team.Name);
            teamNumber.setText(team.Number.toString());
            return rowView;
        }

        @Override
        public Filter getFilter() {
            if (teamFilter == null)
                teamFilter = new TeamFilter();
            return teamFilter;
        }

        private class TeamFilter extends Filter {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null && constraint.length() > 0) {
                    ArrayList<Team> tempList = new ArrayList<Team>();

                    // search content in friend list
                    for (Team team : dataSource) {
                        if (team.getNumberAsString().contains(constraint.toString().toLowerCase()) || team.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                            tempList.add(team);
                        }
                    }

                    filterResults.count = tempList.size();
                    filterResults.values = tempList;
                } else {
                    filterResults.count = dataSource.size();
                    filterResults.values = dataSource;
                }

                return filterResults;
            }

            /**
             * Notify about filtered list to ui
             *
             * @param constraint text
             * @param results    filtered result
             */
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList = (ArrayList<Team>) results.values;
                notifyDataSetChanged();
            }
        }
    }

}
