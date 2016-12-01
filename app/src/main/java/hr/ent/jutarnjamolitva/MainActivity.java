package hr.ent.jutarnjamolitva;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Random;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();

        if ( position == 1 ){
            //SimpleListFragment list = new SimpleListFragment();
            fragmentManager.beginTransaction().replace(R.id.container, SimpleListFragment.newInstance(position+1)).commit();
        }
        else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                    .commit();
        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }/*

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;
            switch(getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    rootView = inflater.inflate(R.layout.fragment_pocetna, container, false);
                    break;

                case 2:
                    rootView = inflater.inflate(R.layout.fragment_lista, container, false);

                    break;

                default:
                    rootView = inflater.inflate(R.layout.fragment_nasumicno, container, false);
                    break;
            }

            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }


    public void rdmButtonOnClick(View view){
        Random r = new Random();
        int Low = 0;
        int High = 10;
        int R = r.nextInt(High-Low) + Low; //This gives you a random number in between 10 (inclusive) and 100 (exclusive)
        changeToMolitvaActivity(this, R);
    }

    public static void changeToMolitvaActivity(Context c, int brojMolitve){
        Intent myIntent = new Intent(c, MolitvaActivity.class);
        myIntent.putExtra("brojMolitve",brojMolitve);
        myIntent.putExtra("secondKeyName","SecondKeyValue");
        c.startActivity(myIntent);
    }


    public static class SimpleListFragment extends ListFragment
    {
        private static final String ARG_SECTION_NUMBER = "section_number";


        public static SimpleListFragment newInstance(int sectionNumber) {
            SimpleListFragment fragment = new SimpleListFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public SimpleListFragment() {
        }


        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            changeToMolitvaActivity(getActivity(), position);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            String[] numbers_text = new String[] {
                    getResources().getString(R.string.title0),
                    getResources().getString(R.string.title1),
                    getResources().getString(R.string.title2),
                    getResources().getString(R.string.title3),
                    getResources().getString(R.string.title4),
                    getResources().getString(R.string.title5),
                    getResources().getString(R.string.title6),
                    getResources().getString(R.string.title7),
                    getResources().getString(R.string.title8),
                    getResources().getString(R.string.title9),
            };

           // Arrays.sort(numbers_text);

           // String[] numbers_digits = new String[] { "1", "2", "3", "4", "5", "6", "7",
           //         "8", "9", "10", "11", "12", "13", "14", "15" };

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    inflater.getContext(), android.R.layout.simple_list_item_1,
                    numbers_text);
            setListAdapter(adapter);
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }


    }
}
