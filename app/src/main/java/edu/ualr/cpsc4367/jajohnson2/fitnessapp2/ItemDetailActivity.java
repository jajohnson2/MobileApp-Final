package edu.ualr.cpsc4367.jajohnson2.fitnessapp2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static edu.ualr.cpsc4367.jajohnson2.fitnessapp2.R.id.videoTV1;

/**
 * An activity representing a single Item detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ItemListActivity}.
 */
public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    setContentView(R.layout.videos);
                    fixLinks();
            }
        });


/*        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageDrawable(getResources().getDrawable(ic_launcher));

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .build();*/

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, ItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Remove underlines from links
    private void stripUnderlines(TextView textView) {
        Spannable s = new SpannableString(textView.getText());
        URLSpan[] spans = s.getSpans(0, s.length(), URLSpan.class);
        for (URLSpan span: spans) {
            int start = s.getSpanStart(span);
            int end = s.getSpanEnd(span);
            s.removeSpan(span);
            span = new URLSpanNoUnderline(span.getURL());
            s.setSpan(span, start, end, 0);
        }
        textView.setText(s);
    }

    //Make all of the links on videos page 'clickable':
    public void fixLinks() {
        TextView t = (TextView) findViewById(videoTV1);
        t.setMovementMethod(LinkMovementMethod.getInstance());
        stripUnderlines(t);

        TextView t2 = (TextView) findViewById(R.id.videoTV2);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
        stripUnderlines(t2);

        TextView t3 = (TextView) findViewById(R.id.videoTV3);
        t3.setMovementMethod(LinkMovementMethod.getInstance());
        stripUnderlines(t3);

        TextView t4 = (TextView) findViewById(R.id.videoTV4);
        t4.setMovementMethod(LinkMovementMethod.getInstance());
        stripUnderlines(t4);

        TextView t5 = (TextView) findViewById(R.id.videoTV5);
        t5.setMovementMethod(LinkMovementMethod.getInstance());
        stripUnderlines(t5);
    }

    // Remove underlines from links
    @SuppressLint("ParcelCreator")
    private class URLSpanNoUnderline extends URLSpan {
        public URLSpanNoUnderline(String url) {
            super(url);
        }
        @Override public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }
    }

    public void logProgress (View view) {
        setContentView(R.layout.progress);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String value1 = preferences.getString("squatValue", "");
        String value2 = preferences.getString("benchValue", "");
        String value3 = preferences.getString("deadValue", "");
        String value4 = preferences.getString("powerValue", "");
        String value5 = preferences.getString("chinValue", "");

        EditText edit1 = (EditText)findViewById(R.id.value1);
        edit1.setText(value1);

        EditText edit2 = (EditText)findViewById(R.id.value2);
        edit2.setText(value2);

        EditText edit3 = (EditText)findViewById(R.id.value3);
        edit3.setText(value3);

        EditText edit4 = (EditText)findViewById(R.id.value4);
        edit4.setText(value4);

        EditText edit5 = (EditText)findViewById(R.id.value5);
        edit5.setText(value5);
    }

    public void saveProgress (View view) {
        EditText edit1 = (EditText)findViewById(R.id.value1);
        String content1 = edit1.getText().toString();

        EditText edit2 = (EditText)findViewById(R.id.value2);
        String content2 = edit2.getText().toString();

        EditText edit3 = (EditText)findViewById(R.id.value3);
        String content3 = edit3.getText().toString();

        EditText edit4 = (EditText)findViewById(R.id.value4);
        String content4 = edit4.getText().toString();

        EditText edit5 = (EditText)findViewById(R.id.value5);
        String content5 = edit5.getText().toString();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("squatValue", content1);
        editor.putString("benchValue", content2);
        editor.putString("deadValue", content3);
        editor.putString("powerValue", content4);
        editor.putString("chinValue", content5);
        editor.apply();

        setContentView(R.layout.videos);
        fixLinks();

        // Toast
        Context context = getApplicationContext();
        CharSequence text = "Saved!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.BOTTOM, 0, 50);
        toast.show();
    }
}
