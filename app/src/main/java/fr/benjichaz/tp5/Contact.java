package fr.benjichaz.tp5;

import android.net.Uri;
import android.widget.ImageView;

/**
 * Created by Benjamin on 03/03/2016.
 */
public class Contact {

    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Uri avatar;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {

        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setAvatar(Uri avatar) {
        this.avatar = avatar;
    }

    public Uri getAvatar() {

        return avatar;
    }
    public Contact(String firstname, String lastname, String phone, String email, Uri avatar) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.avatar = avatar;
    }


}
