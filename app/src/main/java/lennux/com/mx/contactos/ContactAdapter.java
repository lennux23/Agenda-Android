package lennux.com.mx.contactos;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mobilestudio06 on 25/03/15.
 */
public class ContactAdapter extends ArrayAdapter{

    ArrayList<Contact> contacts;
    Context context;

    public ContactAdapter(Context context, int resource, ArrayList<Contact> contacts) {
        super(context, resource, contacts);
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_list_contact,parent,false);

        ViewHolder holder = new ViewHolder();

        holder.txtName = (TextView) rowView.findViewById(R.id.txtName);
        holder.picture = (ImageView) rowView.findViewById(R.id.imgContact);

        Contact contact = contacts.get(position);

        holder.txtName.setText(contact.getName());
        holder.picture.setImageDrawable(contact.getPicture());



        return rowView;
    }


    //Utilizando paradigma
    static class ViewHolder {
        TextView txtName;
        ImageView picture;
    }
}
