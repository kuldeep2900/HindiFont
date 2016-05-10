package home.example.com.sangham_content;

/**
 * Created by ayush on 9/5/16.
 */
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;

public class SpinnerEx4Activity extends Activity implements
        OnItemSelectedListener{
    Spinner s1,s2;

    TextView t;
    String Category,subcategory,comment;
    Spinner spinner,spinner1;
    Context context;
    int nobutton;
    Button btn;
    List<NameValuePair> nameValuePairList;
    EditText editText;
    String foo1;
    UrlEncodedFormEntity form;
    String lang;
    int foo;
    String name;
    private static Map<String, Typeface> TYPEFACE = new HashMap<String, Typeface>();
    JSONArray project, content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_ex4);
        s1 = (Spinner)findViewById(R.id.spinner1);
        s2 = (Spinner)findViewById(R.id.spinner2);
        btn=(Button)findViewById(R.id.button_123);
      //  t=(TextView)findViewById(R.id.kuld);
        editText=(EditText)findViewById(R.id.edit_text);

        s1.setOnItemSelectedListener(this);



       //Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Kruti_Dev_010.ttf");
     //   editText.setTypeface(tf);
    //    editText.setText("अगस्ता वेस्टलैंड का मामला आजकल ");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Category = s1.getSelectedItem().toString();
                subcategory = s2.getSelectedItem().toString();
                comment = editText.getText().toString();
                foo1 = Integer.toString(foo);


                try {
                    URLEncoder.encode("? ???????? ?? ?? ???? ???????", HTTP.UTF_8) ;
                //    form = new UrlEncodedFormEntity(nameValuePairList, HTTP.UTF_8);
                }
                catch (UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }


//
                //       Typeface tf = Typeface.createFromAsset(getAssets(),
                //      "fonts/Kruti_Dev_010.ttf");
                //  t.setTypeface(tf);

                // lang=t.getText().toString();


                //  Typeface tfaerial=Typeface.createFromAsset(getAssets(),"fonts/aerial.ttf");
                //   Typeface tfTradeGothicLight=Typeface.createFromAsset(getAssets(), "fonts/TradeGothic-Light.OTF");

                //    String strt_dialog_desc=SpinnerEx4Activity.this.getResources().getString(s1.getSelectedItem().toString());

                //   tv.setTypeface(fontHindi);

                //      this.tf = attrs.getAttributeValue(
                //        "http://schemas.android.com/apk/res/com.lht", "ttf_name");


                new SendtoServer().execute();


                editText.setText(null);
                s1.setSelection(0);
                s2.setSelection(0);


            }
        });
    }

//    public static Typeface getFonts(Context context, String name) {
//        Typeface typeface = TYPEFACE.get(name);
//        if (typeface == null) {
//            typeface = Typeface.createFromAsset(context.getAssets(), "fonts/DroidHindi.ttf"
//                    + name);
//            TYPEFACE.put(name, typeface);
//        }
//        return typeface;
//    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub
        String sp1= String.valueOf(s1.getSelectedItem());
     //   Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();


        if(sp1.contentEquals("Hinduism")) {
            List<String> list = new ArrayList<String>();
            list.add("Sanatan Dharma");
            list.add("Hindu Culture");
            list.add("Hindu Law");
          //  foo = Integer.parseInt(Category);
            foo=1;

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();

            s2.setAdapter(dataAdapter);
        }
        if(sp1.contentEquals("Spiritual")) {
            List<String> list = new ArrayList<String>();

            list.add("Temples");
            list.add("Gods");
            list.add("Festivals");
            list.add("Books");
         //   foo = Integer.parseInt(Category);
            foo=2;
            foo1=Integer.toString(foo);
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();

            s2.setAdapter(dataAdapter2);


        }
        if(sp1.contentEquals("Health")) {
            List<String> list = new ArrayList<String>();
            list.add("Yoga");
            list.add("Ayurveda");
            list.add("Vastu");
            list.add("Meditation");
          //  foo = Integer.parseInt(Category);
            foo=2;
  //   foo1=Integer.toString(foo);
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);

        }
        if(sp1.contentEquals("Politics")) {
            List<String> list = new ArrayList<String>();
            list.add("Current Affairs");
            list.add("Indian Politics");
            //foo = Integer.parseInt(Category);
            foo=2;
          //  foo1=Integer.toString(foo);
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);

        }




    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    class SendtoServer extends AsyncTask<String, Void, String> {


        ProgressDialog dlg;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dlg = new ProgressDialog(SpinnerEx4Activity.this);
            dlg.setMessage("Saving...");
            dlg.show();
        }


        @Override
        protected String doInBackground(String... params) {


            HttpPost httpPost = new HttpPost();
            DefaultHttpClient httpclient = new DefaultHttpClient();

     nameValuePairList = new ArrayList<NameValuePair>();
            nameValuePairList.add(new BasicNameValuePair("CatId",foo1));
            nameValuePairList.add(new BasicNameValuePair("subcategory", subcategory));
            nameValuePairList.add(new BasicNameValuePair("contents", comment));



//
//try {
//    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
//  //  response = httpclient.execute(httpPost);
//}
//catch (Exception e)
//{
//    e.printStackTrace();


            String result = new ServiceHandler().makeServiceCall("http://trinityapplab.in/RSS/content_insert.php",2, nameValuePairList);
                Log.d("result =", result.toString());

            return result;
        }



        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dlg.dismiss();
        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            //Ask the user if they want to quit
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.symbol_help)
                    .setTitle(R.string.quit)
                    .setMessage(R.string.really_quit)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //Stop the activity
                            SpinnerEx4Activity.this.finish();
                        }

                    })
                    .setNegativeButton(R.string.no, null)
                    .show();

            return true;
        }
        else {
            return super.onKeyDown(keyCode, event);
        }

    }
}