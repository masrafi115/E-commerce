package com.codesw.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class MainActivity extends  AppCompatActivity  { 
	
	
	private String user_key = "";
	private HashMap<String, Object> user_map = new HashMap<>();
	private HashMap<String, Object> review1 = new HashMap<>();
	private String urlDownload = "";
	private String share = "";
	private String time = "";
	private double review_n = 0;
	private HashMap<String, Object> review = new HashMap<>();
	private String folder = "";
	private double n = 0;
	private String myview = "";
	private double position = 0;
	private String saveshare = "";
	private double save_number = 0;
	private String search_icon1 = "";
	private String download_url = "";
	private HashMap<String, Object> save_map = new HashMap<>();
	private String savekey = "";
	private String sppath = "";
	private String spname = "";
	private String services__str = "";
	private String store_key = "";
	private String shareapp = "";
	private double taxt = 0;
	private String v1 = "";
	private String v2 = "";
	private String v3 = "";
	private String v4 = "";
	private String v5 = "";
	private String v6 = "";
	private String v7 = "";
	private double num = 0;
	private String package_name = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String latest_version = "";
	private String your_version = "";
	private String save_key = "";
	private double notynum = 0;
	private double mfirstVisibleItem = 0;
	private double firstVisibleItem = 0;
	private String DBoffer = "";
	private HashMap<String, Object> textADmap = new HashMap<>();
	private String textAD1 = "";
	private double ad = 0;
	private String AD = "";
	private String ADcontact = "";
	private String ADtitle = "";
	private String ADconnectivity = "";
	private String AD_connectivity = "";
	private String update_title = "";
	private String update_message = "";
	private String update_link = "";
	private String date = "";
	private String extra = "";
	private String upi = "";
	private String WhatsApp_number = "";
	private String category_str = "";
	private String contact_number_str = "";
	private String services_str = "";
	private String appReview = "";
	private String nickname = "";
	
	private ArrayList<HashMap<String, Object>> store_listmap = new ArrayList<>();
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> save_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> ad_list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> user_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> ads_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	private ArrayList<String> categorylist = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> appreview_listmap = new ArrayList<>();
	
	private LinearLayout linear14;
	private ImageView imageview1;
	private TextView textview1;
	
	private AlertDialog.Builder ad_d;
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
	private Intent i = new Intent();
	private SharedPreferences user;
	private AlertDialog.Builder exit_d;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		ad_d = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		user = getSharedPreferences("user", Activity.MODE_PRIVATE);
		exit_d = new AlertDialog.Builder(this);
		
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
		user.edit().putString("page", "main").commit();
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			i.setClass(getApplicationContext(), DashboardActivity.class);
			startActivity(i);
		}
		else {
			i.setClass(getApplicationContext(), LoginActivity.class);
			startActivity(i);
			finish();
		}
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
		exit_d.setIcon(R.drawable.img);
		exit_d.setTitle("EXIT");
		exit_d.setMessage("Are you sure you want to exit the app..?");
		exit_d.setPositiveButton("YES", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finish();
			}
		});
		exit_d.setNegativeButton("NO", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				_Toast("ffffff", "0d47a1", "Thanks for stay..!");
			}
		});
		exit_d.setNeutralButton("RATE US !", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				i.setAction(Intent.ACTION_VIEW);
				i.setClass(getApplicationContext(), AppRatingActivity.class);
				startActivity(i);
			}
		});
		exit_d.create().show();
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
	
	
	public void _Send (final Intent _IntentName, final String _to, final String _subject, final String _text) {
		_IntentName.setAction(Intent.ACTION_VIEW);
		_IntentName.setData(Uri.parse("mailto:".concat(_to)));
		_IntentName.putExtra("android.intent.extra.SUBJECT", _subject);
		_IntentName.putExtra("android.intent.extra.TEXT", _text);
		startActivity(_IntentName);
	}
	
	
	public void _copy (final String _copy) {
		((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _copy));
		SketchwareUtil.showMessage(getApplicationContext(), _copy.concat(" Copy successful"));
	}
	
	
	public void _WhatsApp_API (final double _number, final String _text) {
		// You have to add your number with country code, e. g. 49XXXXXXXXXXX for Germany.
		if (_text.equals("")) {
			// Just open chat
			
			
			
		}
		else {
			// Open chat with message
			
			
			
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