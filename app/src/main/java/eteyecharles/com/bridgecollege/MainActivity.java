package eteyecharles.com.bridgecollege;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String COURSE_TITLE = "courseTitle";
    public static final String COURSE_DESC = "courseDesc";
    public static final int DETAIL_REQUEST_CODE = 1001;
    String title=" Introduction to Computer programming";
    protected  List<CourseModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        data = DataProvider.getData();

        ArrayAdapter<CourseModel> courseModelArrayAdapter=
                new CourseArrayAdapter(this,0,data);
        ListView listView= (ListView) findViewById(android.R.id.list);

        listView.setAdapter(courseModelArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CourseModel courseModel=data.get(position);
                displayCourse(courseModel);
            }


        });





//        Iterator<CourseModel> iterator =data.iterator();
//
//        StringBuilder stringBuilder=new StringBuilder();
//
//
//        while (iterator.hasNext()){
//            CourseModel courseModel=iterator.next();
//            stringBuilder.append(courseModel.getCourseTitle())
//                    .append("\n");
//
//
//        }
//        TextView tvTitle= (TextView) findViewById(R.id.tvCourseList);
//        tvTitle.setText(stringBuilder.toString());



    }

    private void displayCourse(CourseModel courseModel) {

//        Log.d("MainActivity","Displaying course: " + courseModel.getCourseTitle());

        Intent detailIntent =new Intent(this,DetailActivity.class);
        detailIntent.putExtra(COURSE_TITLE,courseModel.getCourseTitle());
        detailIntent.putExtra(COURSE_DESC,courseModel.getCourseDescription());



        startActivityForResult(detailIntent,DETAIL_REQUEST_CODE);


    }

    public void btnClickHandler(View view) {
        Intent detailIntent= new Intent(this, DetailActivity.class);

        detailIntent.putExtra(COURSE_TITLE, title);
        startActivityForResult(detailIntent,DETAIL_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==DETAIL_REQUEST_CODE){
            if (resultCode==RESULT_OK){
                String msg=data.getStringExtra("resultMessage");
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            }
        }
    }

    class  CourseArrayAdapter extends ArrayAdapter<CourseModel>{


        Context context;
        List<CourseModel> objects;
        public CourseArrayAdapter(Context context, int resource, List<CourseModel> objects) {
            super(context, resource, objects);

            this.context=context;
            this.objects=objects;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CourseModel courseModel=objects.get(position);
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            View view=inflater.inflate(R.layout.course_item,null);

            TextView tvTitle= (TextView) view.findViewById(R.id.tvTitle);
            tvTitle.setText(courseModel.getCourseTitle());

            ImageView imageCourse= (ImageView) view.findViewById(R.id.imageCourse);

            int res =context.getResources().getIdentifier("image_" +courseModel.getCourseNumber(), "drawable" ,context.getPackageName());
            imageCourse.setImageResource(res);



            return view;





        }
    }
}


