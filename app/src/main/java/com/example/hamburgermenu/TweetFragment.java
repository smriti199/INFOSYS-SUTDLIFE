package com.example.hamburgermenu;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class TweetFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    final int PICK_IMAGE_REQUEST = 1;

    //Button btn_upload = getView().getRootView().findViewById(R.id.btn_upload); // Button that refers to the image selection button in posting tweet page

    private Button btn_upload;
    private ImageView image_view;
    private Uri imageUri;

    private FirebaseAuth mAuth;

    private DatabaseReference mDatabase;


// ...
    FirebaseStorage storage = FirebaseStorage.getInstance("gs://sutd-lyfe-15801.appspot.com");

    StorageReference storageRef = storage.getReference();



    public TweetFragment() {
        // Required empty public constructor
    }

    public static TweetFragment newInstance(String param1, String param2) {
        TweetFragment fragment = new TweetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tweet, container, false);

        Button postTweetButton = view.findViewById(R.id.postTweet);


        btn_upload = view.findViewById(R.id.btn_upload);
        image_view = view.findViewById(R.id.image_view);

        postTweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Registered");
                if (imageUri != null) {
                    System.out.println(imageUri);

                    System.out.println("Sending to Firebase");
                    mDatabase = FirebaseDatabase.getInstance("https://sutd-lyfe-15801-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();

                    DataClass newImage = new DataClass(imageUri);

                    // mDatabase.child("images").child("Test").setValue("hi");

                    storageRef.child("images/myImage.jpg").putFile(imageUri)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    System.out.println("Success");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    System.out.println("Fail");
                                }
                            });


               //  uploadImageToFirebase(imageUri);

                } else {
                    // Handle error
                }
            }
        });

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            imageUri = data.getData();
                            image_view.setImageURI(imageUri);

                        } else {
                            // Handle error
                        }
                    }
                });

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Selecting pictures");
                Intent photoPicker = new Intent();
                photoPicker.setAction(Intent.ACTION_GET_CONTENT);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });


        return view;
    }




}

//    private void uploadToFirebase(Uri uri) {
//        final StorageReference imageReference = storageReference.child(System.currentTimeMillis() + "." + getFileExtension(uri));
//        imageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                DataClass dataClass = new DataClass(uri.toString());
//                String key = databaseReference.push().getKey();
//                databaseReference.child(key).setValue(dataClass);
//
//                Intent intent = new Intent(getActivity(), MainActivity.class);
//                startActivity(intent);
//                getActivity().finish();
//            }
//        });
//    }



//    private String getFileExtension(Uri uri) {
//        ContentResolver contentResolver = getContext().getContentResolver();
//        MimeTypeMap mime = MimeTypeMap.getSingleton();
//        return mime.getExtensionFromMimeType(contentResolver.getType(uri));
//    }
//
//    private void updateUI(FirebaseUser user) {
//        if (user != null) {
//            // User is signed in
//        } else {
//            // User is signed out
//        }
//    }
//
//}
