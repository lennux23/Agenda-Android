package lennux.com.mx.contactos;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by mobilestudio06 on 25/03/15.
 */
public class Contact {
    private String name;
    private String mail;
    private String phone;
    private Drawable picture;
    private String github;
    private String twitter;
    private String facebook;

    public Contact(String name, String mail, String phone, Drawable picture, String github, String twitter, String facebook) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.picture = picture;
        this.github = github;
        this.twitter = twitter;
        this.facebook = facebook;
    }

    public static ArrayList<Contact> getContacts (Context context) {

        ArrayList<Contact> arrayContact= new ArrayList<Contact>();

        arrayContact.add(new Contact("Juan Carlos","jcmtza611@gmail.com","5591988868",context.getResources().getDrawable(R.mipmap.pic_juan),null,null,null));
        arrayContact.add(new Contact("Christian Jesus Rodriguez Martinez","jesusrdzmtzm@gmail.com","5538753188",context.getResources().getDrawable(R.mipmap.pic_chris), "jesusrdzmtzm", "jesusrdzmtzm","1154932578"));
        arrayContact.add(new Contact("Alejandro Xochihua Jorge","alexochihua23@gmail.com","5560116967",context.getResources().getDrawable(R.mipmap.pic_alex), "lennux23", "axj_lennux@hotmail.com", "100000972018165"));
        arrayContact.add(new Contact("Ricardo Centeno Lugo","ricardo.celj@gmail.com","5514382887",context.getResources().getDrawable(R.mipmap.pic_richar),null,null,null));
        arrayContact.add(new Contact("Genaro Rodriguez","grodriguezm@redcibercom.com.mx","5528982474",context.getResources().getDrawable(R.mipmap.pic_genaro),null,null,null));

        return arrayContact;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

}
