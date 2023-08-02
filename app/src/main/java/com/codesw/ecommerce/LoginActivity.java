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
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import java.util.Timer;
import java.util.TimerTask;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Continuation;
import java.io.File;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class LoginActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private HashMap<String, Object> user_map = new HashMap<>();
	private String user_key = "";
	private double one = 0;
	private boolean bol = false;
	private String filename = "";
	private String toPath = "";
	private String toFile = "";
	private double max_size = 0;
	private String fromFile = "";
	private String otp = "";
	private String phoneNumber = "";
	private double number = 0;
	private String verificationCode = "";
	private double account_create = 0;
	private double login_account = 0;
	
	private TextView no_internet;
	private LinearLayout loading_linear;
	private LinearLayout linear4;
	private ImageView imageview6;
	private ProgressBar progressbar12;
	private TextView textview4;
	private LinearLayout gmail_linear;
	private ImageView imageview8;
	private TextView textview12;
	private LinearLayout linear12;
	private LinearLayout linear29;
	private LinearLayout linear33;
	private Button button3;
	private LinearLayout linear20;
	private TextView textview17;
	private EditText edittext5;
	private TextView textview15;
	private EditText edittext4;
	private TextView textview18;
	
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
	private Intent forget_intent = new Intent();
	private SharedPreferences user;
	private DatabaseReference user_id = _firebase.getReference("user_id");
	private ChildEventListener _user_id_child_listener;
	private Intent login_intent = new Intent();
	private TimerTask login_timer;
	private AlertDialog.Builder back_button_D;
	private StorageReference PPSTORAGE = _firebase_storage.getReference("PPSTORAGE");
	private OnCompleteListener<Uri> _PPSTORAGE_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _PPSTORAGE_download_success_listener;
	private OnSuccessListener _PPSTORAGE_delete_success_listener;
	private OnProgressListener _PPSTORAGE_upload_progress_listener;
	private OnProgressListener _PPSTORAGE_download_progress_listener;
	private OnFailureListener _PPSTORAGE_failure_listener;
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private TimerTask t;
	private AlertDialog.Builder dialog;
	private TimerTask forget_t;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.login);
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
		no_internet = (TextView) findViewById(R.id.no_internet);
		loading_linear = (LinearLayout) findViewById(R.id.loading_linear);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		progressbar12 = (ProgressBar) findViewById(R.id.progressbar12);
		textview4 = (TextView) findViewById(R.id.textview4);
		gmail_linear = (LinearLayout) findViewById(R.id.gmail_linear);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		textview12 = (TextView) findViewById(R.id.textview12);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear29 = (LinearLayout) findViewById(R.id.linear29);
		linear33 = (LinearLayout) findViewById(R.id.linear33);
		button3 = (Button) findViewById(R.id.button3);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		textview17 = (TextView) findViewById(R.id.textview17);
		edittext5 = (EditText) findViewById(R.id.edittext5);
		textview15 = (TextView) findViewById(R.id.textview15);
		edittext4 = (EditText) findViewById(R.id.edittext4);
		textview18 = (TextView) findViewById(R.id.textview18);
		auth = FirebaseAuth.getInstance();
		user = getSharedPreferences("user", Activity.MODE_PRIVATE);
		back_button_D = new AlertDialog.Builder(this);
		network = new RequestNetwork(this);
		dialog = new AlertDialog.Builder(this);
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext4.getText().toString().length() > 10) {
					_setError(edittext4, "10 character password only");
				}
				else {
					if (edittext5.getText().toString().equals("") || edittext4.getText().toString().equals("")) {
						_setError(edittext4, "Please Create Password");
					}
					else {
						auth.signInWithEmailAndPassword(edittext5.getText().toString(), edittext4.getText().toString()).addOnCompleteListener(LoginActivity.this, _auth_sign_in_listener);
						loading_linear.setVisibility(View.VISIBLE);
					}
				}
			}
		});
		
		textview17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext5.getText().toString().equals("") || edittext4.getText().toString().equals("")) {
					_setError(edittext4, "Select gmail ro create password and Click create account");
				}
				else {
					auth.createUserWithEmailAndPassword(edittext5.getText().toString(), edittext4.getText().toString()).addOnCompleteListener(LoginActivity.this, _auth_create_user_listener);
					loading_linear.setVisibility(View.VISIBLE);
				}
			}
		});
		
		edittext4.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				button3.setBackgroundColor(0xFF0D47A1);
				button3.setTextColor(0xFFFFFFFF);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		textview18.setOnClickListener(new View.OnClickListener() {
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
		
		_PPSTORAGE_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_PPSTORAGE_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_PPSTORAGE_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_PPSTORAGE_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_PPSTORAGE_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_PPSTORAGE_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", _tag, _network_request_listener);
				no_internet.setVisibility(View.GONE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", _tag, _network_request_listener);
				no_internet.setVisibility(View.VISIBLE);
				no_internet.setText("No internet connection");
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
				if (_success) {
					user.edit().putString("f", "0").commit();
					login_timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									login_intent.setAction(Intent.ACTION_VIEW);
									login_intent.setClass(getApplicationContext(), MainActivity.class);
									startActivity(login_intent);
									finish();
								}
							});
						}
					};
					_timer.schedule(login_timer, (int)(1000));
					_Toast("ffffff", "0d47a1", "Creating a new account please wait...");
				}
				else {
					_Toast("ffffff", "0d47a1", _errorMessage);
					
					
					loading_linear.setVisibility(View.GONE);
					
				}
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					user.edit().putString("f", "0").commit();
					login_timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									_Toast("ffffff", "0d47a1", "LOGIN Successful...");
									login_intent.setAction(Intent.ACTION_VIEW);
									login_intent.setClass(getApplicationContext(), MainActivity.class);
									startActivity(login_intent);
									finish();
								}
							});
						}
					};
					_timer.schedule(login_timer, (int)(1000));
				}
				else {
					_Toast("ffffff", "0d47a1", _errorMessage);
					
					
					loading_linear.setVisibility(View.GONE);
					
				}
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
		user.edit().putString("page", "login").commit();
		network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _network_request_listener);
		_customNav("#0d47a1");
		no_internet.setVisibility(View.GONE);
		loading_linear.setVisibility(View.GONE);
		
		
		
		
		_hideBackButton();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		back_button_D.setIcon(R.drawable.img);
		back_button_D.setTitle("EXIT");
		back_button_D.setMessage("Are you sure you want to exit the app..?");
		back_button_D.setPositiveButton("CONFORM", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				_Toast("ffffff", "0d47a1", "See you later thanks for visit...");
				user.edit().putString("f", "1").commit();
				finish();
			}
		});
		back_button_D.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				_Toast("ffffff", "0d47a1", "Thanks for stay please login...");
			}
		});
		back_button_D.create().show();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _network_request_listener);
	}
	public void _RoundandShadow (final double _Radius, final double _Elevation, final String _color, final View _v) {
		float r = (float) _Radius;
		float e = (float) _Elevation;
		_v.setElevation(e);
		android.graphics.drawable.GradientDrawable s=new android.graphics.drawable.GradientDrawable();
		s.setColor(Color.parseColor(_color));
		s.setCornerRadius(r);
		_v.setBackground(s);
	}
	
	
	public void _ClickColor (final View _v, final String _bcf, final String _scf, final String _bcp, final String _scp, final double _s, final double _r) {
		android.graphics.drawable.GradientDrawable style = new android.graphics.drawable.GradientDrawable();
		style.setCornerRadius((float)_r);
		style.setColor(new android.content.res.ColorStateList(new int[][] {{ -android.R.attr.state_pressed} , {android.R.attr.state_pressed}}, new int [] {Color.parseColor(_bcf), Color.parseColor(_bcp)}));
		style.setStroke((int)_s, new android.content.res.ColorStateList(new int [][] {{ -android.R.attr.state_pressed}, {android.R.attr.state_pressed}}, new int [] {Color.parseColor(_scf), Color.parseColor(_scp)}));
		_v.setBackground(style);
	}
	
	
	public void _LocalNotification (final String _Title, final String _Text) {
		int notifyId = 001;
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		Notification.Builder builder = new Notification.Builder(LoginActivity.this);
		builder.setSmallIcon(R.drawable.icon_kotra2);
		builder.setContentTitle(_Title);
		builder.setContentText(_Text);
		builder.setDefaults( Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			String channelId1 = "1";
			String channelName1 = "channel1";
			NotificationChannel channel = new NotificationChannel(channelId1, channelName1, NotificationManager.IMPORTANCE_DEFAULT);
			channel.enableLights(true);
			channel.setLightColor(Color.RED);
			channel.setShowBadge(true);
			channel.enableVibration(true);
			builder.setChannelId(channelId1);
			if (mNotificationManager != null) {
				mNotificationManager.createNotificationChannel(channel);
			}
		} else {
			builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
		}
		Intent intent = getIntent();
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
		stackBuilder.addNextIntent(intent);
		PendingIntent pendingIntent = stackBuilder.getPendingIntent(001, PendingIntent.FLAG_UPDATE_CURRENT);
		builder.setContentIntent(pendingIntent);
		if (mNotificationManager != null) {
			mNotificationManager.notify(notifyId, builder.build());
		}
	}
	
	
	public void _customNav (final String _color) {
		
	}
	
	
	public void _LengthOfEditText (final TextView _editText, final double _value_character) {
		InputFilter[] gb = _editText.getFilters(); InputFilter[] newFilters = new InputFilter[gb.length + 1]; System.arraycopy(gb, 0, newFilters, 0, gb.length); newFilters[gb.length] = new InputFilter.LengthFilter((int)_value_character); _editText.setFilters(newFilters);
	}
	
	
	public void _inEdittextView (final View _button, final TextView _textview, final String _charSeq) {
		if (_charSeq.trim().equals("")) {
			_RoundandShadow(8, 12, "#e0e0e0", _button);
			_textview.setTextColor(0xFF0D47A1);
		}
		else {
			_RoundandShadow(0, 12, "#0d47a1", _button);
			_textview.setTextColor(0xFFFFFFFF);
		}
	}
	
	
	public void _setError (final View _v, final String _message) {
		try {
			EditText edit = (EditText)_v;
			edit.setError(_message);
		} catch(Exception e) {
			showMessage(e.toString());
		}
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
	
	
	public void _hideBackButton () {
		 getSupportActionBar().setDisplayShowTitleEnabled(true); getSupportActionBar().setDisplayHomeAsUpEnabled(false);
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