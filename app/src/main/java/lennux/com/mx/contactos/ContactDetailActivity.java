package lennux.com.mx.contactos;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class ContactDetailActivity extends ActionBarActivity implements View.OnClickListener{

    private int contactPosition;
    private Contact contact;
    ImageButton actionCall, actionEmail, actionGithub, actionTwitter, actionFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        Intent intent = getIntent();
        contactPosition = intent.getIntExtra("CONTACT", 0);

        contact = Contact.getContacts(getApplicationContext()).get(contactPosition);

        RoundedImageView profileImage = (RoundedImageView) findViewById(R.id.profileImage);
        TextView tvNameDetail = (TextView) findViewById(R.id.txtNameDetail);
        TextView tvMailDetail = (TextView) findViewById(R.id.txtMailDetail);
        TextView tvPhoneDetail = (TextView) findViewById(R.id.txtPhoneDetail);

        TextView tvGithubDetail = (TextView) findViewById(R.id.txtGithubDetail);
        TextView tvTwitterDetail = (TextView) findViewById(R.id.txtTwitterDetail);
        TextView tvFacebookDetail = (TextView) findViewById(R.id.txtFacebookDetail);

        profileImage.setImageDrawable(contact.getPicture());
        tvNameDetail.setText(contact.getName());
        tvMailDetail.setText(contact.getMail());
        tvPhoneDetail.setText(contact.getPhone());
        tvGithubDetail.setText(contact.getGithub());
        tvTwitterDetail.setText(contact.getTwitter());
        tvFacebookDetail.setText(contact.getFacebook());

        actionCall = (ImageButton) findViewById(R.id.actionCall);
        actionEmail = (ImageButton) findViewById(R.id.actionMail);
        actionGithub = (ImageButton) findViewById(R.id.actionGithub);
        actionTwitter = (ImageButton) findViewById(R.id.actionTwitter);
        actionFacebook = (ImageButton) findViewById(R.id.actionFacebook);

        actionCall.setOnClickListener(this);
        actionEmail.setOnClickListener(this);
        actionGithub.setOnClickListener(this);
        actionTwitter.setOnClickListener(this);
        actionFacebook.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_detail, menu);
        return true;
    }

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
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.actionCall:
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String uri = "tel:" + contact.getPhone();

                callIntent.setData(Uri.parse(uri));
                if (isAvailable(getApplicationContext(), callIntent))
                    startActivity(callIntent);
                else
                    Toast.makeText(getApplicationContext(), "HARWARE NOT AVAILABLE", Toast.LENGTH_LONG).show();

                break;
            case R.id.actionMail:
                Log.e("INETNT", "email");
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", contact.getMail(), null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "EXTRA_SUBJECT");

                if(isAvailable(getApplicationContext(),emailIntent))
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                else
                    Toast.makeText(getApplicationContext(),"HARWARE NOT AVAILABLE", Toast.LENGTH_LONG).show();

                break;
            case R.id.actionGithub:
                Intent gihubIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "http://www.github.com/"+ contact.getGithub()));

                if(isAvailable(getApplicationContext(),gihubIntent))
                    startActivity(gihubIntent);
                else
                    Toast.makeText(getApplicationContext(),"HARWARE NOT AVAILABLE", Toast.LENGTH_LONG).show();

                break;
            case R.id.actionTwitter:
                Intent twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "twitter://user?screen_name="+ contact.getTwitter()));

                if(isAvailable(getApplicationContext(),twitterIntent))
                    startActivity(twitterIntent);
                else
                    Toast.makeText(getApplicationContext(),"HARWARE NOT AVAILABLE", Toast.LENGTH_LONG).show();

                break;
            case R.id.actionFacebook:
                Intent faceIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "fb://profile/" +contact.getFacebook()));

                if(isAvailable(getApplicationContext(),faceIntent))
                    startActivity(faceIntent);
                else
                    Toast.makeText(getApplicationContext(),"HARWARE NOT AVAILABLE", Toast.LENGTH_LONG).show();

                break;
        }


    }


    public static boolean isAvailable(Context ctx, Intent intent) {
        final PackageManager mgr = ctx.getPackageManager();
        List<ResolveInfo> list =
                mgr.queryIntentActivities(intent,
                        PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
}
