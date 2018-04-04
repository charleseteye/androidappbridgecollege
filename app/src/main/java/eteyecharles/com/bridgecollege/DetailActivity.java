package eteyecharles.com.bridgecollege;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    protected  String courseTitle;
//    protected  String courseDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        courseTitle=getIntent().getStringExtra(MainActivity.COURSE_TITLE);
        TextView tvTitle= (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(courseTitle);

        String courseDesc=getIntent().getStringExtra(MainActivity.COURSE_DESC);
        TextView tvDesc= (TextView) findViewById(R.id.tvDescription);
        tvDesc.setText(courseDesc);

//        courseDescription=getIntent().getStringExtra(MainActivity.COURSE_DESC);
//        TextView tvDescription= (TextView) findViewById(R.id.tvDescription);
//        tvTitle.setText(courseDescription);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        inflate the menu this action adds items to the action bar if present
        getMenuInflater().inflate(R.menu.menu, menu);

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id =item.getItemId();
        if (id==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    public void registerClickHandler(View view) {
        getIntent().putExtra("resultMessage","you registered for "+courseTitle);
        setResult(RESULT_OK,getIntent());
        finish();
    }
}
