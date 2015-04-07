package lennux.com.mx.contactos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ContactDetailActivity extends ActionBarActivity {

    private int contactPosition;
    private Contact contact;

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

        profileImage.setImageDrawable(contact.getPicture());
        tvNameDetail.setText(contact.getName());
        tvMailDetail.setText(contact.getMail());
        tvPhoneDetail.setText(contact.getPhone());
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
}
