# AndroidMVVM

# Follow and give a star :star:
Connect with me on [Linkedin](https://www.linkedin.com/in/satishsharma1/) as well to support this project. 

<h1>Android + MVVM + Retrofit  </h1>

MVVM: Model-View-ViewModel (MVVM) is a structural design pattern that separates objects into three distinct groups: Models hold application data. 

Retrofit: Retrofit turns your HTTP API into a Java interface. A type-safe HTTP client for Android and Java. Introduction. Retrofit turns your HTTP API into a Java interface

![Screenshot](https://github.com/sharmadevelopers/AndroidMVVM/blob/master/MVVM.JPG?raw=true)


The code would look like this:

 ```
 // MARK: Card Item ViewModel
 
public class CardItemViewModel extends BaseObservable {

    private CardModel model;
    private Context context;

    public CardItemViewModel(Context context) {
        this.context = context;
    }

    public void setModel(CardModel model) {
        this.model = model;
    }

    public CardModel getModel() {
        return model;
    }

    @Bindable
    public String getName() {
        return getModel().getLogin();
    }

    public String getUserImage() {
        return getModel().getAvatar_url();
    }

    @BindingAdapter({"bind:imgUrl"})
    public static void setProfilePicture(ImageView imageView, String imgUrl) {
        Glide.with(imageView.getContext()).load(imgUrl).into(imageView);
    }
 ```



 ```
// MARK: Model CardModel

public class CardModel extends BaseModel implements Parcelable {

    private int id;
    private String  login;
    private String  avatar_url;
    
 }
 
 ```

# Thanks
[Retrofit](https://square.github.io/retrofit/)

# License

AndroidMVVM is available under the MIT license. See the LICENSE file for more info.
