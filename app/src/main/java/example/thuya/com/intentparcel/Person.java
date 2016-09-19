package example.thuya.com.intentparcel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by thuyha on 28/08/2016.
 */
public class Person implements Parcelable {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        //return 0, because has no FileDescriptor
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // have to follow the order of declaration
        dest.writeString(name);
        dest.writeInt(age);
    }


    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

}
