package com.codesw.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ProgressBar;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Continuation;
import android.net.Uri;
import java.io.File;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.content.ClipData;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.content.ClipboardManager;
import com.bumptech.glide.Glide;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class ProfileActivity extends  AppCompatActivity  { 
	
	public final int REQ_CD_PPIC = 101;
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private HashMap<String, Object> pmap = new HashMap<>();
	private String ppath = "";
	private String pname = "";
	private double uploadPhotos = 0;
	private double uploadText = 0;
	private String getkey = "";
	
	private ArrayList<HashMap<String, Object>> user_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> rplist = new ArrayList<>();
	
	private LinearLayout linear4;
	private ScrollView profile_vscroll1;
	private LinearLayout upload_linear;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear34;
	private ListView listview1;
	private TextView textview69;
	private TextView textview70;
	private LinearLayout linear9;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear3;
	private TextView textview9;
	private TextView story_t;
	private LinearLayout linear6;
	private LinearLayout linear36;
	private LinearLayout linear33;
	private ImageView pic_img;
	private LinearLayout linear35;
	private TextView textview67;
	private TextView textview68;
	private TextView textview66;
	private TextView textview6;
	private TextView nickname_t;
	private TextView textview7;
	private TextView contact_t;
	private TextView textview8;
	private TextView email_t;
	private TextView textview11;
	private ImageView imageview3;
	private LinearLayout main_loading_linear;
	private ImageView imageview2;
	private LinearLayout linear31;
	private EditText edittext1;
	private EditText edittext2;
	private EditText edittext3;
	private EditText edittext4;
	private Button button1;
	private LinearLayout linear32;
	private ImageView imageview5;
	private ProgressBar progressbar2;
	private TextView textview65;
	private ProgressBar progressbar1;
	private TextView pp_loading;
	private ImageView imageview4;
	private TextView textview12;
	
	private DatabaseReference user_id = _firebase.getReference("user_id");
	private ChildEventListener _user_id_child_listener;
	private FirebaseAuth auth;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private StorageReference user_photo = _firebase_storage.getReference("user_photo");
	private OnCompleteListener<Uri> _user_photo_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _user_photo_download_success_listener;
	private OnSuccessListener _user_photo_delete_success_listener;
	private OnProgressListener _user_photo_upload_progress_listener;
	private OnProgressListener _user_photo_download_progress_listener;
	private OnFailureListener _user_photo_failure_listener;
	private SharedPreferences pp;
	private Intent i = new Intent();
	private Intent ppic = new Intent(Intent.ACTION_GET_CONTENT);
	private TimerTask u_time;
	private DatabaseReference RESELLPRODUCT = _firebase.getReference("RESELLPRODUCT");
	private ChildEventListener _RESELLPRODUCT_child_listener;
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_app_bar = (AppBarLayout) findViewById(R.id._app_bar);
		_coordinator = (CoordinatorLayout) findViewById(R.id._coordinator);
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		profile_vscroll1 = (ScrollView) findViewById(R.id.profile_vscroll1);
		upload_linear = (LinearLayout) findViewById(R.id.upload_linear);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear34 = (LinearLayout) findViewById(R.id.linear34);
		listview1 = (ListView) findViewById(R.id.listview1);
		textview69 = (TextView) findViewById(R.id.textview69);
		textview70 = (TextView) findViewById(R.id.textview70);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		textview9 = (TextView) findViewById(R.id.textview9);
		story_t = (TextView) findViewById(R.id.story_t);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear36 = (LinearLayout) findViewById(R.id.linear36);
		linear33 = (LinearLayout) findViewById(R.id.linear33);
		pic_img = (ImageView) findViewById(R.id.pic_img);
		linear35 = (LinearLayout) findViewById(R.id.linear35);
		textview67 = (TextView) findViewById(R.id.textview67);
		textview68 = (TextView) findViewById(R.id.textview68);
		textview66 = (TextView) findViewById(R.id.textview66);
		textview6 = (TextView) findViewById(R.id.textview6);
		nickname_t = (TextView) findViewById(R.id.nickname_t);
		textview7 = (TextView) findViewById(R.id.textview7);
		contact_t = (TextView) findViewById(R.id.contact_t);
		textview8 = (TextView) findViewById(R.id.textview8);
		email_t = (TextView) findViewById(R.id.email_t);
		textview11 = (TextView) findViewById(R.id.textview11);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		main_loading_linear = (LinearLayout) findViewById(R.id.main_loading_linear);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear31 = (LinearLayout) findViewById(R.id.linear31);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		edittext3 = (EditText) findViewById(R.id.edittext3);
		edittext4 = (EditText) findViewById(R.id.edittext4);
		button1 = (Button) findViewById(R.id.button1);
		linear32 = (LinearLayout) findViewById(R.id.linear32);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		progressbar2 = (ProgressBar) findViewById(R.id.progressbar2);
		textview65 = (TextView) findViewById(R.id.textview65);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		pp_loading = (TextView) findViewById(R.id.pp_loading);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview12 = (TextView) findViewById(R.id.textview12);
		auth = FirebaseAuth.getInstance();
		pp = getSharedPreferences("pp", Activity.MODE_PRIVATE);
		ppic.setType("image/*");
		ppic.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		network = new RequestNetwork(this);
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				profile_vscroll1.setVisibility(View.GONE);
				upload_linear.setVisibility(View.VISIBLE);
			}
		});
		
		pic_img.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				profile_vscroll1.setVisibility(View.GONE);
				upload_linear.setVisibility(View.VISIBLE);
			}
		});
		
		textview67.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview66.getText().toString()));
				_Toast("ffffff", "0d47a1", "Copy STORE Key");
			}
		});
		
		textview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(ppic, REQ_CD_PPIC);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext3.getText().toString().length() > 013) {
					_Toast("ffffff", "0d47a1", "Please crop +91 in mobile number");
				}
				else {
					if (edittext1.getText().toString().equals("")) {
						_Toast("ffffff", "0d47a1", "type your nickname");
					}
					else {
						if (edittext2.getText().toString().equals("")) {
							_Toast("ffffff", "0d47a1", "type your email address");
						}
						else {
							if (edittext3.getText().toString().equals("")) {
								_Toast("ffffff", "0d47a1", "type your contact number");
							}
							else {
								if (edittext4.getText().toString().equals("")) {
									_Toast("ffffff", "0d47a1", "type your story");
								}
								else {
									if (pp.getString("pp", "").equals("")) {
										_Toast("ffffff", "0d47a1", "feed your profile photo");
									}
									else {
										pmap = new HashMap<>();
										pmap.put("user key", FirebaseAuth.getInstance().getCurrentUser().getUid());
										pmap.put("nickname", edittext1.getText().toString());
										pmap.put("email address", edittext2.getText().toString());
										pmap.put("mobile number", "+91".concat(edittext3.getText().toString()));
										pmap.put("story", edittext4.getText().toString());
										pmap.put("profile", pp.getString("pp", ""));
										user_id.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(pmap);
										pmap.clear();
										edittext1.setText("");
										edittext2.setText("");
										edittext3.setText("");
										edittext4.setText("");
										u_time = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														profile_vscroll1.setVisibility(View.VISIBLE);
														upload_linear.setVisibility(View.GONE);
													}
												});
											}
										};
										_timer.schedule(u_time, (int)(1000));
										main_loading_linear.setVisibility(View.VISIBLE);
									}
								}
							}
						}
					}
				}
			}
		});
		
		linear32.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				profile_vscroll1.setVisibility(View.VISIBLE);
				upload_linear.setVisibility(View.GONE);
			}
		});
		
		textview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_user_id_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				user_id.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						user_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								user_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
							if (_childValue.containsKey("email address")) {
								if (_childValue.get("email address").toString().equals("")) {
									email_t.setText("No data...");
								}
								else {
									email_t.setText(_childValue.get("email address").toString());
									edittext2.setText(_childValue.get("email address").toString());
								}
							}
							if (_childValue.containsKey("nickname")) {
								if (_childValue.get("nickname").toString().equals("")) {
									nickname_t.setText("No data...");
								}
								else {
									nickname_t.setText(_childValue.get("nickname").toString());
									edittext1.setText(_childValue.get("nickname").toString());
								}
							}
							if (_childValue.containsKey("mobile number")) {
								if (_childValue.get("mobile number").toString().equals("")) {
									contact_t.setText("No data...");
								}
								else {
									contact_t.setText(_childValue.get("mobile number").toString());
									edittext3.setText(_childValue.get("mobile number").toString());
								}
							}
							if (_childValue.containsKey("story")) {
								if (_childValue.get("story").toString().equals("")) {
									story_t.setText("No data...");
								}
								else {
									story_t.setText(_childValue.get("story").toString());
									edittext4.setText(_childValue.get("story").toString());
								}
							}
							if (_childValue.containsKey("user key")) {
								if (_childValue.get("user key").toString().equals("")) {
									textview66.setText("No data...");
								}
								else {
									textview66.setText(_childValue.get("user key").toString());
								}
							}
							if (_childValue.containsKey("profile")) {
								if (_childValue.get("profile").toString().equals("")) {
									pic_img.setImageResource(R.drawable.boy);
								}
								else {
									_curcle_igm_url(_childValue.get("profile").toString(), pic_img);
								}
							}
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		user_id.addChildEventListener(_user_id_child_listener);
		
		_user_photo_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				pp_loading.setText(String.valueOf((long)(_progressValue)));
				linear31.setVisibility(View.VISIBLE);
				progressbar1.setProgress((int)_progressValue);
			}
		};
		
		_user_photo_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_user_photo_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				pp.edit().putString("pp", _downloadUrl).commit();
				pp_loading.setText(" successfully upload profile photo...");
				pp_loading.setTextColor(0xFF64DD17);
				progressbar1.setVisibility(View.GONE);
			}
		};
		
		_user_photo_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_user_photo_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_user_photo_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_RESELLPRODUCT_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		RESELLPRODUCT.addChildEventListener(_RESELLPRODUCT_child_listener);
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _network_request_listener);
				textview70.setVisibility(View.GONE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _network_request_listener);
				textview70.setVisibility(View.VISIBLE);
				textview70.setText("No internet connection...");
			}
		};
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		linear31.setVisibility(View.GONE);
		textview70.setVisibility(View.GONE);
		main_loading_linear.setVisibility(View.GONE);
		network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _network_request_listener);
		_ClickColor(edittext1, "#ffffff", "#9e9e9e", "#ffffff", "#0d47a1", 4, 25);
		_ClickColor(edittext2, "#ffffff", "#9e9e9e", "#ffffff", "#0d47a1", 4, 25);
		_ClickColor(edittext3, "#ffffff", "#9e9e9e", "#ffffff", "#0d47a1", 4, 25);
		_ClickColor(edittext4, "#ffffff", "#9e9e9e", "#ffffff", "#0d47a1", 4, 25);
		_ClickColor(button1, "#0d47a1", "#ffffff", "#9e9e9e", "#ffffff", 4, 25);
		_ClickColor(textview67, "#0d47a1", "#ffffff", "#9e9e9e", "#ffffff", 4, 25);
		_ClickColor(linear36, "#0d47a1", "#ffffff", "#9e9e9e", "#ffffff", 4, 25);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_PPIC:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				ppath = _filePath.get((int)(0));
				pname = Uri.parse(_filePath.get((int)(0))).getLastPathSegment();
				_curcle_igm_url(ppath, pic_img);
				user_photo.child(pname).putFile(Uri.fromFile(new File(ppath))).addOnFailureListener(_user_photo_failure_listener).addOnProgressListener(_user_photo_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return user_photo.child(pname).getDownloadUrl();
					}}).addOnCompleteListener(_user_photo_upload_success_listener);
			}
			else {
				_Toast("ffffff", "0d47a1", "Uploading Cancel...");
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _network_request_listener);
	}
	public void _Toast (final String _bg, final String _st, final String _msg) {
		TextView tvu = new TextView(this);
		
		tvu.setLayoutParams(
		  new ViewGroup.LayoutParams(
		    android.widget.LinearLayout
		    .LayoutParams.WRAP_CONTENT,
		    android.widget.LinearLayout
		    .LayoutParams.WRAP_CONTENT)
		);
		tvu.setTextColor(Color.parseColor("#"+_st));
		tvu.setGravity(Gravity.CENTER);
		tvu.setText(_msg);
		
		
		LinearLayout v = new LinearLayout(this);
		
		android.graphics.drawable.GradientDrawable gd =
		  new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor("#"+_bg));
		gd.setStroke((int)getDip(2), Color.parseColor("#"+_st));
		gd.setCornerRadius(6);
		v.setBackground(gd);
		v.setPadding((int)getDip(8),(int)getDip(8),(int)getDip(8),(int)getDip(8));
		
		v.addView(tvu);
		
		
		Toast t = Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT);
		t.setView(v);
		t.show();
	}
	
	
	public void _ClickColor (final View _v, final String _bcf, final String _scf, final String _bcp, final String _scp, final double _s, final double _r) {
		android.graphics.drawable.GradientDrawable style = new android.graphics.drawable.GradientDrawable();
		style.setCornerRadius((float)_r);
		style.setColor(new android.content.res.ColorStateList(new int[][] {{ -android.R.attr.state_pressed} , {android.R.attr.state_pressed}}, new int [] {Color.parseColor(_bcf), Color.parseColor(_bcp)}));
		style.setStroke((int)_s, new android.content.res.ColorStateList(new int [][] {{ -android.R.attr.state_pressed}, {android.R.attr.state_pressed}}, new int [] {Color.parseColor(_scf), Color.parseColor(_scp)}));
		_v.setBackground(style);
	}
	
	
	public void _card_style (final View _view, final double _shadow, final double _rounds, final String _colour) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_colour));
		gd.setCornerRadius((int)_rounds);
		_view.setBackground(gd);
		_view.setElevation((int)_shadow);
	}
	
	
	public void _curcle_igm_url (final String _url, final ImageView _img_view) {
		
		Glide.with(getApplicationContext()).asBitmap().load(_url).centerCrop().into(new com.bumptech.glide.request.target.BitmapImageViewTarget(_img_view) {
			@Override protected void setResource(Bitmap resource) {
				androidx.core.graphics.drawable.RoundedBitmapDrawable circularBitmapDrawable = androidx.core.graphics.drawable.RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(), resource); circularBitmapDrawable.setCircular(true); _img_view.setImageDrawable(circularBitmapDrawable);
			}
		});
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.productview, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final LinearLayout linear7 = (LinearLayout) _view.findViewById(R.id.linear7);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final TextView extra_t = (TextView) _view.findViewById(R.id.extra_t);
			final LinearLayout linear8 = (LinearLayout) _view.findViewById(R.id.linear8);
			final LinearLayout linear5 = (LinearLayout) _view.findViewById(R.id.linear5);
			final LinearLayout linear9 = (LinearLayout) _view.findViewById(R.id.linear9);
			final LinearLayout linear4 = (LinearLayout) _view.findViewById(R.id.linear4);
			final TextView product = (TextView) _view.findViewById(R.id.product);
			final TextView userkey_t = (TextView) _view.findViewById(R.id.userkey_t);
			final TextView whatsapp_t = (TextView) _view.findViewById(R.id.whatsapp_t);
			final TextView call_t = (TextView) _view.findViewById(R.id.call_t);
			final ImageView imageview4 = (ImageView) _view.findViewById(R.id.imageview4);
			final TextView textview10 = (TextView) _view.findViewById(R.id.textview10);
			final TextView date_t = (TextView) _view.findViewById(R.id.date_t);
			final ImageView imageview5 = (ImageView) _view.findViewById(R.id.imageview5);
			final TextView tview = (TextView) _view.findViewById(R.id.tview);
			final TextView textview12 = (TextView) _view.findViewById(R.id.textview12);
			final TextView textview3 = (TextView) _view.findViewById(R.id.textview3);
			final TextView textview6 = (TextView) _view.findViewById(R.id.textview6);
			final TextView amount = (TextView) _view.findViewById(R.id.amount);
			final ImageView imageview2 = (ImageView) _view.findViewById(R.id.imageview2);
			final TextView textview7 = (TextView) _view.findViewById(R.id.textview7);
			final TextView address = (TextView) _view.findViewById(R.id.address);
			final ImageView imageview3 = (ImageView) _view.findViewById(R.id.imageview3);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			final TextView description = (TextView) _view.findViewById(R.id.description);
			
			if (rplist.get((int)(rplist.size() - 1) - _position).containsKey("day") && (rplist.get((int)(rplist.size() - 1) - _position).containsKey("month") && rplist.get((int)(rplist.size() - 1) - _position).containsKey("year"))) {
				date_t.setText(rplist.get((int)(rplist.size() - 1) - _position).get("day").toString().concat("/".concat(rplist.get((int)(rplist.size() - 1) - _position).get("month").toString().concat("/".concat(rplist.get((int)(rplist.size() - 1) - _position).get("year").toString())))));
			}
			if (rplist.get((int)(rplist.size() - 1) - _position).containsKey("product photo")) {
				Glide.with(getApplicationContext()).load(Uri.parse(rplist.get((int)(rplist.size() - 1) - _position).get("product photo").toString())).into(imageview1);
			}
			else {
				imageview1.setImageResource(R.drawable.tv1);
			}
			if (rplist.get((int)(rplist.size() - 1) - _position).containsKey("user key")) {
				userkey_t.setText(rplist.get((int)(rplist.size() - 1) - _position).get("user key").toString());
			}
			if (rplist.get((int)(rplist.size() - 1) - _position).containsKey("extra")) {
				extra_t.setText(rplist.get((int)(rplist.size() - 1) - _position).get("extra").toString());
			}
			if (rplist.get((int)(rplist.size() - 1) - _position).containsKey("product name")) {
				product.setText(rplist.get((int)(rplist.size() - 1) - _position).get("product name").toString());
			}
			if (rplist.get((int)(rplist.size() - 1) - _position).containsKey("product price")) {
				amount.setText(rplist.get((int)(rplist.size() - 1) - _position).get("product price").toString());
			}
			if (rplist.get((int)(rplist.size() - 1) - _position).containsKey("country code") && rplist.get((int)(rplist.size() - 1) - _position).containsKey("contact number")) {
				call_t.setText(rplist.get((int)(rplist.size() - 1) - _position).get("country code").toString().concat(rplist.get((int)(rplist.size() - 1) - _position).get("contact number").toString()));
			}
			if (rplist.get((int)(rplist.size() - 1) - _position).containsKey("country code") && rplist.get((int)(rplist.size() - 1) - _position).containsKey("whatsapp number")) {
				whatsapp_t.setText(rplist.get((int)(rplist.size() - 1) - _position).get("country code").toString().concat(rplist.get((int)(rplist.size() - 1) - _position).get("whatsapp number").toString()));
			}
			if (rplist.get((int)(rplist.size() - 1) - _position).containsKey("area") && (rplist.get((int)(rplist.size() - 1) - _position).containsKey("city") && rplist.get((int)(rplist.size() - 1) - _position).containsKey("state"))) {
				address.setText(rplist.get((int)(rplist.size() - 1) - _position).get("area").toString().concat(" ".concat(rplist.get((int)(rplist.size() - 1) - _position).get("city").toString().concat(" ".concat(rplist.get((int)(rplist.size() - 1) - _position).get("state").toString())))));
			}
			if (rplist.get((int)(rplist.size() - 1) - _position).containsKey("description")) {
				description.setText(rplist.get((int)(rplist.size() - 1) - _position).get("description").toString());
			}
			if (rplist.get((int)(rplist.size() - 1) - _position).containsKey("views")) {
				tview.setText(rplist.get((int)(rplist.size() - 1) - _position).get("views").toString());
			}
			_card_style(linear1, 16, 40, "#ffffff");
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}