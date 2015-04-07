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

    public Contact(String name, String mail, String phone, Drawable picture) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.picture = picture;
    }

    public static ArrayList<Contact> getContacts (Context context) {

        ArrayList<Contact> arrayContact= new ArrayList<Contact>();

        arrayContact.add(new Contact("Juan Carlos","jcmtza611@gmail.com","5591988868",context.getResources().getDrawable(R.mipmap.pic_juan)));
        arrayContact.add(new Contact("Christian Jesus Rodriguez Martinez","jesusrdzmtzm@gmail.com","5538753188",context.getResources().getDrawable(R.mipmap.pic_chris)));
        arrayContact.add(new Contact("Alejandro Xochihua Jorge","alexochihua23@gmail.com","5560116967",context.getResources().getDrawable(R.mipmap.pic_alex)));
        arrayContact.add(new Contact("Ricardo Centeno Lugo","ricardo.celj@gmail.com","5514382887",context.getResources().getDrawable(R.mipmap.pic_richar)));
        arrayContact.add(new Contact("Genaro Rodriguez","grodriguezm@redcibercom.com.mx","5528982474",context.getResources().getDrawable(R.mipmap.pic_genaro)));

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

}
