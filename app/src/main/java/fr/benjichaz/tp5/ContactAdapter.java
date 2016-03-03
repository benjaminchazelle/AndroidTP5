package fr.benjichaz.tp5;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Benjamin on 03/03/2016.
 */
public class ContactAdapter extends ArrayAdapter<Contact>  {

    //tweets est la liste des models à afficher
    public ContactAdapter(Context context, List<Contact> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_contact, parent, false);
        }

        ContactViewHolder viewHolder = (ContactViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ContactViewHolder();
            viewHolder.identity = (TextView) convertView.findViewById(R.id.identity);
            viewHolder.contact = (TextView) convertView.findViewById(R.id.contact);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Contact contact = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.identity.setText(contact.getFirstname() + " " + contact.getLastname());
        viewHolder.contact.setText(contact.getPhone() + " - " + contact.getEmail());

        if(contact.getAvatar() != null)
            viewHolder.avatar.setImageURI(contact.getAvatar());
        else
            viewHolder.avatar.setImageResource(R.drawable.default_avatar);

        return convertView;
    }



    private class ContactViewHolder{
        public TextView identity;
        public TextView contact;
        public ImageView avatar;
    }


}