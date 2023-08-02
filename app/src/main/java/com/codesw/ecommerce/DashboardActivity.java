package com.codesw.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
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
import android.widget.TextView;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ScrollView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
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
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.content.ClipData;
import android.content.ClipboardManager;
import com.bumptech.glide.Glide;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class DashboardActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	private String user_key = "";
	private String urlDownload = "";
	private String share = "";
	private String time = "";
	private String folder = "";
	private String myview = "";
	private String download_url = "";
	private String saveshare = "";
	private String savekey = "";
	private String sppath = "";
	private String spname = "";
	private String services__str = "";
	private String search_icon1 = "";
	private String store_key = "";
	private String shareapp = "";
	private String v1 = "";
	private String v2 = "";
	private String v3 = "";
	private String v4 = "";
	private String v5 = "";
	private String v6 = "";
	private String v7 = "";
	private String package_name = "";
	private String latest_version = "";
	private String your_version = "";
	private String save_key = "";
	private String DBoffer = "";
	private String textAD1 = "";
	private String ADcontact = "";
	private String ADtitle = "";
	private String AD = "";
	private String ADconnectivity = "";
	private String AD_connectivity = "";
	private String update_message = "";
	private String update_title = "";
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
	private double review_n = 0;
	private double n = 0;
	private double position = 0;
	private double num = 0;
	private double notynum = 0;
	private double taxt = 0;
	private double ad = 0;
	private HashMap<String, Object> user_map = new HashMap<>();
	private HashMap<String, Object> save_map = new HashMap<>();
	private HashMap<String, Object> review = new HashMap<>();
	private HashMap<String, Object> review1 = new HashMap<>();
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> textADmap = new HashMap<>();
	private double save_number = 0;
	private double firstVisibleItem = 0;
	private double mfirstVisibleItem = 0;
	
	private ArrayList<HashMap<String, Object>> store_listmap = new ArrayList<>();
	private ArrayList<String> categorylist = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> save_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> ad_list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> ads_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> appreview_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> user_listmap = new ArrayList<>();
	private ArrayList<String> list = new ArrayList<>();
	
	private TextView no_internet;
	private LinearLayout linear11;
	private LinearLayout linear1;
	private WebView webview1;
	private LinearLayout linear13;
	private ImageView imageview3;
	private TextView textview67;
	private LinearLayout linear10;
	private LinearLayout storepage;
	private LinearLayout list_linear;
	private LinearLayout toolsbar;
	private LinearLayout main_loading_linear;
	private ListView listview1;
	private ImageView imageview1;
	private ProgressBar progressbar1;
	private TextView textview65;
	private EditText search_bar;
	private Spinner spinner1;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_drawer_linear2;
	private ScrollView _drawer_vscroll1;
	private LinearLayout _drawer_linear14;
	private ImageView _drawer_imageview2;
	private LinearLayout _drawer_linear10;
	private LinearLayout _drawer_linear15;
	private ImageView _drawer_imageview12;
	private TextView _drawer_textview13;
	private ImageView _drawer_imageview13;
	private TextView _drawer_textview14;
	private TextView _drawer_textview15;
	private LinearLayout _drawer_linear13;
	private LinearLayout _drawer_linear18profile;
	private LinearLayout _drawer_create_store;
	private LinearLayout _drawer_time_pass;
	private LinearLayout _drawer_training;
	private LinearLayout _drawer_new_update;
	private LinearLayout _drawer_blogs;
	private LinearLayout _drawer_share_app;
	private LinearLayout _drawer_feedback;
	private LinearLayout _drawer_about_us;
	private LinearLayout _drawer_privacy_policy;
	private LinearLayout _drawer_logout_linear;
	private LinearLayout _drawer_linear17;
	private LinearLayout _drawer_linear16;
	private ImageView _drawer_imageview15;
	private TextView _drawer_textview22;
	private ImageView _drawer_imageview4;
	private TextView _drawer_emailaddress;
	private ImageView _drawer_imageview14;
	private TextView _drawer_textview21;
	private ImageView _drawer_imageview5;
	private TextView _drawer_mobilenumber;
	private ImageView _drawer_imageview6;
	private TextView _drawer_textview1;
	private TextView _drawer_app_review_t;
	private ImageView _drawer_imageview7;
	private TextView _drawer_nickname;
	private ImageView _drawer_imageview8;
	private TextView _drawer_textview3;
	private ImageView _drawer_imageview9;
	private TextView _drawer_textview9;
	private ImageView _drawer_imageview10;
	private TextView _drawer_textview10;
	private ImageView _drawer_imageview11;
	private TextView _drawer_textview11;
	private ImageView _drawer_imageview1;
	private TextView _drawer_textview6;
	private ImageView _drawer_help_;
	private ImageView _drawer_face_;
	private ImageView _drawer_whats_;
	
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
	private DatabaseReference user_id = _firebase.getReference("user_id");
	private ChildEventListener _user_id_child_listener;
	private DatabaseReference review_db = _firebase.getReference("review_db");
	private ChildEventListener _review_db_child_listener;
	private DatabaseReference STORE_DB = _firebase.getReference("STORE_DB");
	private ChildEventListener _STORE_DB_child_listener;
	private RequestNetwork NETWORK;
	private RequestNetwork.RequestListener _NETWORK_request_listener;
	private StorageReference PPSTORAGE = _firebase_storage.getReference("PPSTORAGE");
	private OnCompleteListener<Uri> _PPSTORAGE_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _PPSTORAGE_download_success_listener;
	private OnSuccessListener _PPSTORAGE_delete_success_listener;
	private OnProgressListener _PPSTORAGE_upload_progress_listener;
	private OnProgressListener _PPSTORAGE_download_progress_listener;
	private OnFailureListener _PPSTORAGE_failure_listener;
	private DatabaseReference TEXTAD = _firebase.getReference("TEXTAD");
	private ChildEventListener _TEXTAD_child_listener;
	private DatabaseReference APPREVIEW = _firebase.getReference("APPREVIEW");
	private ChildEventListener _APPREVIEW_child_listener;
	private DatabaseReference ver = _firebase.getReference("version");
	private ChildEventListener _ver_child_listener;
	private SharedPreferences user;
	private SharedPreferences store_pp_image;
	private SharedPreferences sp;
	private SharedPreferences store_image_sp;
	private SharedPreferences ad_sp;
	private Intent login_intent = new Intent();
	private Intent profile_intent = new Intent();
	private Intent calling_i = new Intent();
	private Intent whatsapp_i = new Intent();
	private Intent review_i = new Intent();
	private Intent email_i = new Intent();
	private Intent payment_i = new Intent();
	private AlertDialog.Builder ad_d;
	private AlertDialog.Builder store_create_D;
	private AlertDialog.Builder exit_d;
	private Intent ad_i = new Intent();
	private Intent ad_i1 = new Intent();
	private Intent app_review_i = new Intent();
	private Intent profile_i = new Intent();
	private TimerTask ad_time;
	private TimerTask st_time;
	private AlertDialog.Builder dialog;
	private Intent intent = new Intent();
	private Intent open_i = new Intent();
	private Intent product_i = new Intent();
	private Intent timepass_i = new Intent();
	private Intent help_i = new Intent();
	private Intent upi_i = new Intent();
	private Intent about_i = new Intent();
	private Intent big_i = new Intent();
	private Intent training_i = new Intent();
	private Intent feedback = new Intent();
	private Intent blogs = new Intent();
	private AlertDialog.Builder services_dialog;
	private Calendar calendar = Calendar.getInstance();
	private ObjectAnimator pageview_oa = new ObjectAnimator();
	private Intent privacy_policy_i = new Intent();
	private Intent face_i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.dashboard);
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
		_drawer = (DrawerLayout) findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(DashboardActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);
		
		no_internet = (TextView) findViewById(R.id.no_internet);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview67 = (TextView) findViewById(R.id.textview67);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		storepage = (LinearLayout) findViewById(R.id.storepage);
		list_linear = (LinearLayout) findViewById(R.id.list_linear);
		toolsbar = (LinearLayout) findViewById(R.id.toolsbar);
		main_loading_linear = (LinearLayout) findViewById(R.id.main_loading_linear);
		listview1 = (ListView) findViewById(R.id.listview1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		textview65 = (TextView) findViewById(R.id.textview65);
		search_bar = (EditText) findViewById(R.id.search_bar);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		_drawer_linear1 = (LinearLayout) _nav_view.findViewById(R.id.linear1);
		_drawer_drawer_linear2 = (LinearLayout) _nav_view.findViewById(R.id.drawer_linear2);
		_drawer_vscroll1 = (ScrollView) _nav_view.findViewById(R.id.vscroll1);
		_drawer_linear14 = (LinearLayout) _nav_view.findViewById(R.id.linear14);
		_drawer_imageview2 = (ImageView) _nav_view.findViewById(R.id.imageview2);
		_drawer_linear10 = (LinearLayout) _nav_view.findViewById(R.id.linear10);
		_drawer_linear15 = (LinearLayout) _nav_view.findViewById(R.id.linear15);
		_drawer_imageview12 = (ImageView) _nav_view.findViewById(R.id.imageview12);
		_drawer_textview13 = (TextView) _nav_view.findViewById(R.id.textview13);
		_drawer_imageview13 = (ImageView) _nav_view.findViewById(R.id.imageview13);
		_drawer_textview14 = (TextView) _nav_view.findViewById(R.id.textview14);
		_drawer_textview15 = (TextView) _nav_view.findViewById(R.id.textview15);
		_drawer_linear13 = (LinearLayout) _nav_view.findViewById(R.id.linear13);
		_drawer_linear18profile = (LinearLayout) _nav_view.findViewById(R.id.linear18profile);
		_drawer_create_store = (LinearLayout) _nav_view.findViewById(R.id.create_store);
		_drawer_time_pass = (LinearLayout) _nav_view.findViewById(R.id.time_pass);
		_drawer_training = (LinearLayout) _nav_view.findViewById(R.id.training);
		_drawer_new_update = (LinearLayout) _nav_view.findViewById(R.id.new_update);
		_drawer_blogs = (LinearLayout) _nav_view.findViewById(R.id.blogs);
		_drawer_share_app = (LinearLayout) _nav_view.findViewById(R.id.share_app);
		_drawer_feedback = (LinearLayout) _nav_view.findViewById(R.id.feedback);
		_drawer_about_us = (LinearLayout) _nav_view.findViewById(R.id.about_us);
		_drawer_privacy_policy = (LinearLayout) _nav_view.findViewById(R.id.privacy_policy);
		_drawer_logout_linear = (LinearLayout) _nav_view.findViewById(R.id.logout_linear);
		_drawer_linear17 = (LinearLayout) _nav_view.findViewById(R.id.linear17);
		_drawer_linear16 = (LinearLayout) _nav_view.findViewById(R.id.linear16);
		_drawer_imageview15 = (ImageView) _nav_view.findViewById(R.id.imageview15);
		_drawer_textview22 = (TextView) _nav_view.findViewById(R.id.textview22);
		_drawer_imageview4 = (ImageView) _nav_view.findViewById(R.id.imageview4);
		_drawer_emailaddress = (TextView) _nav_view.findViewById(R.id.emailaddress);
		_drawer_imageview14 = (ImageView) _nav_view.findViewById(R.id.imageview14);
		_drawer_textview21 = (TextView) _nav_view.findViewById(R.id.textview21);
		_drawer_imageview5 = (ImageView) _nav_view.findViewById(R.id.imageview5);
		_drawer_mobilenumber = (TextView) _nav_view.findViewById(R.id.mobilenumber);
		_drawer_imageview6 = (ImageView) _nav_view.findViewById(R.id.imageview6);
		_drawer_textview1 = (TextView) _nav_view.findViewById(R.id.textview1);
		_drawer_app_review_t = (TextView) _nav_view.findViewById(R.id.app_review_t);
		_drawer_imageview7 = (ImageView) _nav_view.findViewById(R.id.imageview7);
		_drawer_nickname = (TextView) _nav_view.findViewById(R.id.nickname);
		_drawer_imageview8 = (ImageView) _nav_view.findViewById(R.id.imageview8);
		_drawer_textview3 = (TextView) _nav_view.findViewById(R.id.textview3);
		_drawer_imageview9 = (ImageView) _nav_view.findViewById(R.id.imageview9);
		_drawer_textview9 = (TextView) _nav_view.findViewById(R.id.textview9);
		_drawer_imageview10 = (ImageView) _nav_view.findViewById(R.id.imageview10);
		_drawer_textview10 = (TextView) _nav_view.findViewById(R.id.textview10);
		_drawer_imageview11 = (ImageView) _nav_view.findViewById(R.id.imageview11);
		_drawer_textview11 = (TextView) _nav_view.findViewById(R.id.textview11);
		_drawer_imageview1 = (ImageView) _nav_view.findViewById(R.id.imageview1);
		_drawer_textview6 = (TextView) _nav_view.findViewById(R.id.textview6);
		_drawer_help_ = (ImageView) _nav_view.findViewById(R.id.help_);
		_drawer_face_ = (ImageView) _nav_view.findViewById(R.id.face_);
		_drawer_whats_ = (ImageView) _nav_view.findViewById(R.id.whats_);
		auth = FirebaseAuth.getInstance();
		NETWORK = new RequestNetwork(this);
		user = getSharedPreferences("user", Activity.MODE_PRIVATE);
		store_pp_image = getSharedPreferences("store_pp_image", Activity.MODE_PRIVATE);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		store_image_sp = getSharedPreferences("store_image_sp", Activity.MODE_PRIVATE);
		ad_sp = getSharedPreferences("ad_sp", Activity.MODE_PRIVATE);
		ad_d = new AlertDialog.Builder(this);
		store_create_D = new AlertDialog.Builder(this);
		exit_d = new AlertDialog.Builder(this);
		dialog = new AlertDialog.Builder(this);
		services_dialog = new AlertDialog.Builder(this);
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
		
		linear13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				product_i.setAction(Intent.ACTION_VIEW);
				product_i.setClass(getApplicationContext(), ProductActivity.class);
				startActivity(product_i);
			}
		});
		
		search_bar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (SketchwareUtil.getRandom((int)(0), (int)(5)) == 1) {
					_LocalNotification("🛒 सर्च करें अपने एरिया का नाम 🛍️", "और पाएं लोकल 🛺ऑटो रिक्शा 🧼किराना स्टोर 🛏️फर्नीचर 🧾रेंटल सर्विस 🥦सब्जी वाला 🥛दूध वाला 🗞️पेपर वाला और भी बहुत सारी सर्विसेस 💉💊💍🧢🧦👔🎮🏀🎺🎁🎠✈️💺🚖");
				}
			}
		});
		
		search_bar.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				_search(_charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					
				}
				if (_position == 1) {
					search_bar.setText("Groceries / Kirana Store");
				}
				if (_position == 2) {
					search_bar.setText("Milk parlour / Dairy");
				}
				if (_position == 3) {
					search_bar.setText("Vegetable and fruits store");
				}
				if (_position == 4) {
					search_bar.setText("Restaurant and food centre");
				}
				if (_position == 5) {
					search_bar.setText("Mobile and DTH store");
				}
				if (_position == 6) {
					search_bar.setText("Laundry");
				}
				if (_position == 7) {
					search_bar.setText("Electrician");
				}
				if (_position == 8) {
					search_bar.setText("Passenger vehicle");
				}
				if (_position == 9) {
					search_bar.setText("Salon and parlour");
				}
				if (_position == 10) {
					search_bar.setText("vehicle private driver");
				}
				if (_position == 11) {
					search_bar.setText("Doctor and hospital");
				}
				if (_position == 12) {
					search_bar.setText("Vehicle mechanic");
				}
				if (_position == 13) {
					search_bar.setText("Home appliances mechanic");
				}
				if (_position == 14) {
					search_bar.setText("Hardware store");
				}
				if (_position == 15) {
					search_bar.setText("Plumber worker");
				}
				if (_position == 16) {
					search_bar.setText("Event organiser");
				}
				if (_position == 17) {
					search_bar.setText("Events and party worker");
				}
				if (_position == 18) {
					search_bar.setText("Paint store");
				}
				if (_position == 19) {
					search_bar.setText("Painter worker");
				}
				if (_position == 20) {
					search_bar.setText("Advocate");
				}
				if (_position == 21) {
					search_bar.setText("School project and stationery");
				}
				if (_position == 22) {
					search_bar.setText("Building material store");
				}
				if (_position == 23) {
					search_bar.setText("Jcb , tow truck and big vehicles");
				}
				if (_position == 24) {
					search_bar.setText("Loading vehicle");
				}
				if (_position == 25) {
					search_bar.setText("Rental service");
				}
				if (_position == 26) {
					search_bar.setText("Tent house party decorator");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
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
							if (_childValue.containsKey("nickname")) {
								if (_childValue.get("nickname").toString().equals("")) {
									profile_i.setClass(getApplicationContext(), ProfileActivity.class);
									startActivity(profile_i);
									finish();
								}
								else {
									_getEmail(_childValue.get("nickname").toString());
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
		
		_review_db_child_listener = new ChildEventListener() {
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
		review_db.addChildEventListener(_review_db_child_listener);
		
		_STORE_DB_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				main_loading_linear.setVisibility(View.GONE);
				toolsbar.setVisibility(View.VISIBLE);
				st_time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								STORE_DB.addListenerForSingleValueEvent(new ValueEventListener() {
									@Override
									public void onDataChange(DataSnapshot _dataSnapshot) {
										store_listmap = new ArrayList<>();
										try {
											GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
											for (DataSnapshot _data : _dataSnapshot.getChildren()) {
												HashMap<String, Object> _map = _data.getValue(_ind);
												store_listmap.add(_map);
											}
										}
										catch (Exception _e) {
											_e.printStackTrace();
										}
										list.add(_childKey);
										listview1.setAdapter(new Listview1Adapter(store_listmap));
										((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
									}
									@Override
									public void onCancelled(DatabaseError _databaseError) {
									}
								});
							}
						});
					}
				};
				_timer.schedule(st_time, (int)(200));
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				STORE_DB.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						store_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								store_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(store_listmap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
		STORE_DB.addChildEventListener(_STORE_DB_child_listener);
		
		_NETWORK_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				NETWORK.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", _tag, _NETWORK_request_listener);
				no_internet.setVisibility(View.GONE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				NETWORK.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", _tag, _NETWORK_request_listener);
				no_internet.setText("No Internet Connection");
				no_internet.setVisibility(View.VISIBLE);
			}
		};
		
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
		
		_TEXTAD_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				textAD1 = _childValue.get("Text AD 1").toString();
				webview1.loadUrl("data:text/html,<html><body> <marquee behavior=\"scroll\" direction=\"left\"> <h2<alignt style=\"color:red\">".concat(_childValue.get("Text AD 1").toString().concat("</marquee></html></body> ")));
				ADtitle = _childValue.get("AD title").toString();
				AD = _childValue.get("AD").toString();
				AD_connectivity = _childValue.get("ADconnectivity").toString();
				ADcontact = _childValue.get("AD contact").toString();
				ad_time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if (!(ad_sp.getString("Data", "").equals(_childValue.get("AD title").toString()) && (ad_sp.getString("Data", "").equals(_childValue.get("AD").toString()) && (ad_sp.getString("Data", "").equals(_childValue.get("ADconnectivity").toString()) && ad_sp.getString("Data", "").equals(_childValue.get("AD contact").toString()))))) {
									ad_d.setIcon(R.drawable.imgad);
									ad_d.setTitle(ADtitle);
									ad_d.setMessage(AD);
									ad_d.setPositiveButton("SKIP", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											ad_sp.edit().putString("Data", AD).commit();
										}
									});
									ad_d.setNeutralButton("More info", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											ad_i1.setAction(Intent.ACTION_VIEW);
											ad_i1.setData(Uri.parse(AD_connectivity.concat(ADcontact)));
											startActivity(ad_i1);
											_Toast("ffffff", "0d47a1", "Please wait connecting");
										}
									});
									ad_d.setCancelable(false);
									ad_d.create().show();
								}
							}
						});
					}
				};
				_timer.schedule(ad_time, (int)(400));
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				textAD1 = _childValue.get("Text AD 1").toString();
				webview1.loadUrl("data:text/html,<html><body> <marquee behavior=\"scroll\" direction=\"left\"> <h2<alignt style=\"color:red\">".concat(_childValue.get("Text AD 1").toString().concat("</marquee></html></body> ")));
				ADtitle = _childValue.get("AD title").toString();
				AD = _childValue.get("AD").toString();
				AD_connectivity = _childValue.get("ADconnectivity").toString();
				ADcontact = _childValue.get("AD contact").toString();
				if (!(ad_sp.getString("Data", "").equals(_childValue.get("AD title").toString()) && (ad_sp.getString("Data", "").equals(_childValue.get("AD").toString()) && (ad_sp.getString("Data", "").equals(_childValue.get("ADconnectivity").toString()) && ad_sp.getString("Data", "").equals(_childValue.get("AD contact").toString()))))) {
					ad_d.setIcon(R.drawable.imgad);
					ad_d.setTitle(ADtitle);
					ad_d.setMessage(AD);
					ad_d.setPositiveButton("SKIP", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							ad_sp.edit().putString("Data", AD).commit();
						}
					});
					ad_d.setNeutralButton("More info", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							ad_i1.setAction(Intent.ACTION_VIEW);
							ad_i1.setData(Uri.parse(AD_connectivity.concat(ADcontact)));
							startActivity(ad_i1);
							_Toast("ffffff", "0d47a1", "Please wait connecting");
						}
					});
					ad_d.setCancelable(false);
					ad_d.create().show();
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				textAD1 = _childValue.get("Text AD 1").toString();
				webview1.loadUrl("data:text/html,<html><body> <marquee behavior=\"scroll\" direction=\"left\"> <h2<alignt style=\"color:red\">".concat(_childValue.get("Text AD 1").toString().concat("</marquee></html></body> ")));
				ADtitle = _childValue.get("AD title").toString();
				AD = _childValue.get("AD").toString();
				AD_connectivity = _childValue.get("ADconnectivity").toString();
				ADcontact = _childValue.get("AD contact").toString();
				if (!(ad_sp.getString("Data", "").equals(_childValue.get("AD title").toString()) && (ad_sp.getString("Data", "").equals(_childValue.get("AD").toString()) && (ad_sp.getString("Data", "").equals(_childValue.get("ADconnectivity").toString()) && ad_sp.getString("Data", "").equals(_childValue.get("AD contact").toString()))))) {
					ad_d.setIcon(R.drawable.imgad);
					ad_d.setTitle(ADtitle);
					ad_d.setMessage(AD);
					ad_d.setPositiveButton("SKIP", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							ad_sp.edit().putString("Data", AD).commit();
						}
					});
					ad_d.setNeutralButton("More info", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							ad_i1.setAction(Intent.ACTION_VIEW);
							ad_i1.setData(Uri.parse(AD_connectivity.concat(ADcontact)));
							startActivity(ad_i1);
							_Toast("ffffff", "0d47a1", "Please wait connecting");
						}
					});
					ad_d.setCancelable(false);
					ad_d.create().show();
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		TEXTAD.addChildEventListener(_TEXTAD_child_listener);
		
		_APPREVIEW_child_listener = new ChildEventListener() {
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
		APPREVIEW.addChildEventListener(_APPREVIEW_child_listener);
		
		_ver_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				update_title = _childValue.get("title").toString();
				update_message = _childValue.get("message").toString();
				update_link = _childValue.get("link").toString();
				st_time = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_UPDATE(update_title, update_message, update_link, ver);
							}
						});
					}
				};
				_timer.schedule(st_time, (int)(300));
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
		ver.addChildEventListener(_ver_child_listener);
		
		_drawer_linear18profile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				profile_i.setAction(Intent.ACTION_VIEW);
				profile_i.setClass(getApplicationContext(), ProfileActivity.class);
				startActivity(profile_i);
			}
		});
		
		_drawer_create_store.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				payment_i.setAction(Intent.ACTION_VIEW);
				payment_i.setClass(getApplicationContext(), PementActivity.class);
				startActivity(payment_i);
			}
		});
		
		_drawer_time_pass.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				timepass_i.setAction(Intent.ACTION_VIEW);
				timepass_i.setClass(getApplicationContext(), TimepassActivity.class);
				startActivity(timepass_i);
			}
		});
		
		_drawer_training.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				training_i.setAction(Intent.ACTION_VIEW);
				training_i.setClass(getApplicationContext(), TrainingActivity.class);
				startActivity(training_i);
			}
		});
		
		_drawer_new_update.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				app_review_i.setAction(Intent.ACTION_VIEW);
				app_review_i.setClass(getApplicationContext(), AppRatingActivity.class);
				startActivity(app_review_i);
			}
		});
		
		_drawer_blogs.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				blogs.setAction(Intent.ACTION_VIEW);
				blogs.setData(Uri.parse("http://www.kotracontacts.in/?m=1"));
				startActivity(blogs);
			}
		});
		
		_drawer_share_app.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shareapp = "KOTRAContacts App\n".concat("\nअब लोकल मार्केट को मिलेगा व्यापार अपनी ऑनलाइन दुकान बनाएं और व्यापार बढ़ाएं दुकान बनाने के लिए नीचे दिए लिंक पर क्लिक करें।\n\n📲 Free Download Now\nhttp://www.kotracontacts.in/2020/05/blog-post.html?m=1");
				Intent i = new Intent(android.content.Intent.ACTION_SEND);i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT,shareapp); startActivity(Intent.createChooser(i,"Click to Share"));
			}
		});
		
		_drawer_feedback.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Send(feedback, "kotracontacts@gmail.com", "Please your feedback", "");
			}
		});
		
		_drawer_about_us.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				about_i.setAction(Intent.ACTION_VIEW);
				about_i.setClass(getApplicationContext(), AboutActivity.class);
				startActivity(about_i);
			}
		});
		
		_drawer_privacy_policy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				privacy_policy_i.setAction(Intent.ACTION_VIEW);
				privacy_policy_i.setData(Uri.parse("https://kotracontacts.blogspot.com/p/blog-page.html?m=1"));
				startActivity(privacy_policy_i);
			}
		});
		
		_drawer_logout_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FirebaseAuth.getInstance().signOut();
				user.edit().putString("user key", "").commit();
				login_intent.setAction(Intent.ACTION_VIEW);
				login_intent.setClass(getApplicationContext(), LoginActivity.class);
				startActivity(login_intent);
			}
		});
		
		_drawer_help_.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				help_i.setAction(Intent.ACTION_DIAL);
				help_i.setData(Uri.parse("tel:+919770070858"));
				startActivity(help_i);
			}
		});
		
		_drawer_face_.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				face_i.setAction(Intent.ACTION_VIEW);
				face_i.setData(Uri.parse("https://www.facebook.com/KOTRAContacts-App-110819850622489/"));
				startActivity(face_i);
			}
		});
		
		_drawer_whats_.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_WhatsApp_API(919770070858d, "हम आपकी क्या मदद कर सकते हैं..?");
			}
		});
		
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
		user_id.removeEventListener(_user_id_child_listener);
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			user_id.addChildEventListener(_user_id_child_listener);
			_getreview();
			no_internet.setVisibility(View.GONE);
			toolsbar.setVisibility(View.GONE);
			_refresh_listmap();
			_services_spinner();
			_ClickColor(search_bar, "#ffffff", "#0d47a1", "#ffffff", "#9e9e9e", 4, 80);
			notynum = 1000;
			st_time = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							notynum--;
							if (notynum == 0) {
								_LocalNotification("आपके क्षेत्र के लोकल बिजनेस के कांटेक्ट नंबर ", "टिफिन सेंटर, प्लंबर, इलेक्ट्रिशियन, ड्राइवर, मैकेनिक, किराना स्टोर, ऑटो रिक्शा, ट्रैवल एजेंसी");
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(st_time, (int)(0), (int)(1000));
			_shape(39, 0, 0, 39, "#0D47A1", "#0D47A1", 8, linear13);
			_UpdateApp("com.codesw.ecommerce", ver);
			if (SketchwareUtil.getRandom((int)(0), (int)(25)) == 1) {
				_NewTapTarget(linear13, "Resale Product", "खरीदने व बेचने के लिए क्लिक करें ।", "#0d47a1");
			}
		}
		else {
			login_intent.setClass(getApplicationContext(), LoginActivity.class);
			startActivity(login_intent);
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
	public void onStart() {
		super.onStart();
		no_internet.setVisibility(View.GONE);
		if (user.getString("page", "").equals("login") && user.getString("f", "").equals("1")) {
			finish();
		}
		NETWORK.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _NETWORK_request_listener);
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
				review_i.setAction(Intent.ACTION_VIEW);
				review_i.setClass(getApplicationContext(), AppRatingActivity.class);
				startActivity(review_i);
			}
		});
		exit_d.create().show();
	}
	
	@Override
	protected void onPostCreate(Bundle _savedInstanceState) {
		super.onPostCreate(_savedInstanceState);
		notynum = 12000;
		st_time = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						notynum--;
						if (notynum == 0) {
							_LocalNotification("🏺सेकंड हैंड प्रोडक्ट खरीदने व बेचने के लिए क्लिक करें ।📱", "📺 📻🛢️🚲 🚖 🏍️ पुराना (unused) सामान बेचने के लिए हम कोटरा कांटेक्ट ऐप use करते हैं");
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(st_time, (int)(0), (int)(1000));
	}
	
	@Override
	public void onResume() {
		super.onResume();
		notynum = 6000;
		st_time = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						notynum--;
						if (notynum == 0) {
							_LocalNotification("हम आपके लिए क्या कर सकते हैं", "टिफिन सेंटर, प्लंबर, इलेक्ट्रिशियन, ड्राइवर, मैकेनिक, किराना स्टोर, ऑटो रिक्शा, ट्रैवल एजेंसी आदि सर्विस🤳");
							st_time.cancel();
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(st_time, (int)(0), (int)(1000));
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
	
	
	public void _shape (final double _top1, final double _top2, final double _bottom2, final double _bottom1, final String _inside_color, final String _side_color, final double _side_size, final View _view) {
		Double tlr = _top1;
		Double trr = _top2;
		Double blr = _bottom2;
		Double brr = _bottom1;
		Double sw = _side_size;
		android.graphics.drawable.GradientDrawable s = new android.graphics.drawable.GradientDrawable();
		s.setShape(android.graphics.drawable.GradientDrawable.RECTANGLE);
		s.setCornerRadii(new float[] {tlr.floatValue(),tlr.floatValue(), trr.floatValue(),trr.floatValue(), blr.floatValue(),blr.floatValue(), brr.floatValue(),brr.floatValue()}); 
		
		s.setColor(Color.parseColor(_inside_color));
		s.setStroke(sw.intValue(), Color.parseColor(_side_color));
		_view.setBackground(s);
	}
	
	
	public void _view_3D (final View _v, final double _n) {
		_v.setElevation((float)_n);
	}
	
	
	public void _getreview () {
		review_db.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				store_listmap = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						store_listmap.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				review1 = new HashMap<>();
				review_n = 0;
				for(int _repeat15 = 0; _repeat15 < (int)(store_listmap.size()); _repeat15++) {
					if (store_listmap.get((int)review_n).containsKey("post_key")) {
						if (review1.containsKey(store_listmap.get((int)review_n).get("post_key").toString())) {
							review1.put(store_listmap.get((int)review_n).get("post_key").toString(), String.valueOf((long)(Double.parseDouble(review1.get(store_listmap.get((int)review_n).get("post_key").toString()).toString()) + 1)));
						}
						else {
							review1.put(store_listmap.get((int)review_n).get("post_key").toString(), "1");
						}
					}
					review_n++;
				}
				store_listmap.clear();
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
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
	
	
	public void _ClickColor (final View _v, final String _bcf, final String _scf, final String _bcp, final String _scp, final double _s, final double _r) {
		android.graphics.drawable.GradientDrawable style = new android.graphics.drawable.GradientDrawable();
		style.setCornerRadius((float)_r);
		style.setColor(new android.content.res.ColorStateList(new int[][] {{ -android.R.attr.state_pressed} , {android.R.attr.state_pressed}}, new int [] {Color.parseColor(_bcf), Color.parseColor(_bcp)}));
		style.setStroke((int)_s, new android.content.res.ColorStateList(new int [][] {{ -android.R.attr.state_pressed}, {android.R.attr.state_pressed}}, new int [] {Color.parseColor(_scf), Color.parseColor(_scp)}));
		_v.setBackground(style);
	}
	
	
	public void _services_spinner () {
		categorylist.add("STORE CATEGORIES");
		categorylist.add("Groceries / Kirana Store");
		categorylist.add("Milk parlour / Dairy");
		categorylist.add("Vegetable and fruits store");
		categorylist.add("Restaurant and food centre's");
		categorylist.add("Mobile and DTH store");
		categorylist.add("Laundry's");
		categorylist.add("Electrician's");
		categorylist.add("Passenger vehicle's");
		categorylist.add("Salon and parlours");
		categorylist.add("vehicle private driver's");
		categorylist.add("Doctor and hospital's");
		categorylist.add("vehicle mechanic's");
		categorylist.add("home appliances mechanic's");
		categorylist.add("Hardware store's");
		categorylist.add("Plumber worker's");
		categorylist.add("Event organiser's");
		categorylist.add("Events and party worker's");
		categorylist.add("Paint store's");
		categorylist.add("Painter worker's");
		categorylist.add("Advocate's and Lawyer's");
		categorylist.add("School project and stationery");
		categorylist.add("Building material store's");
		categorylist.add("Jcb , tow truck and big vehicles");
		categorylist.add("Loading vehicle's");
		categorylist.add("Rental service's");
		categorylist.add("Tent house party decorator's");
		categorylist.add("More services coming soon...📣");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, categorylist));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _copy (final String _copy) {
		((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", _copy));
		SketchwareUtil.showMessage(getApplicationContext(), _copy.concat(" Copy successful"));
	}
	
	
	public void _search (final String _charSeq) {
		STORE_DB.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				store_listmap = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						store_listmap.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				if (_charSeq.length() > 0) {
					taxt = store_listmap.size();
					n = store_listmap.size() - 1;
					for(int _repeat20 = 0; _repeat20 < (int)(taxt); _repeat20++) {
						v1 = store_listmap.get((int)n).get("store category").toString().concat(" ".concat(store_listmap.get((int)n).get("store area").toString().concat(" ".concat(store_listmap.get((int)n).get("store city").toString().concat(" ".concat(store_listmap.get((int)n).get("store state").toString().concat(" ".concat(store_listmap.get((int)n).get("store number").toString().concat(" ".concat(store_listmap.get((int)n).get("store country").toString().concat(" ".concat(store_listmap.get((int)n).get("user key").toString()))))))))))));
						v2 = store_listmap.get((int)n).get("store area").toString();
						v3 = store_listmap.get((int)n).get("store city").toString();
						v4 = store_listmap.get((int)n).get("store state").toString();
						v5 = store_listmap.get((int)n).get("store number").toString();
						v6 = store_listmap.get((int)n).get("store country").toString();
						v7 = store_listmap.get((int)n).get("user key").toString();
						if (!(_charSeq.length() > v1.length()) && v1.toLowerCase().contains(_charSeq.toLowerCase())) {
							
						}
						else {
							if (!(_charSeq.length() > v2.length()) && v2.toLowerCase().contains(_charSeq.toLowerCase())) {
								
							}
							else {
								if (!(_charSeq.length() > v3.length()) && v3.toLowerCase().contains(_charSeq.toLowerCase())) {
									
								}
								else {
									if (!(_charSeq.length() > v4.length()) && v4.toLowerCase().contains(_charSeq.toLowerCase())) {
										
									}
									else {
										if (!(_charSeq.length() > v5.length()) && v5.toLowerCase().contains(_charSeq.toLowerCase())) {
											
										}
										else {
											if (!(_charSeq.length() > v6.length()) && v6.toLowerCase().contains(_charSeq.toLowerCase())) {
												
											}
											else {
												if (!(_charSeq.length() > v7.length()) && v7.toLowerCase().contains(_charSeq.toLowerCase())) {
													
												}
												else {
													store_listmap.remove((int)(n));
												}
											}
										}
									}
								}
							}
						}
						n--;
					}
					listview1.setAdapter(new Listview1Adapter(store_listmap));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
	}
	
	
	public void _LocalNotification (final String _Title, final String _Text) {
		int notifyId = 001;
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		Notification.Builder builder = new Notification.Builder(DashboardActivity.this);
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
	
	
	public void _getEmail (final String _email) {
		nickname = _email;
		_drawer_textview15.setText(nickname);
	}
	
	
	public void _WhatsApp_API (final double _number, final String _text) {
		// You have to add your number with country code, e. g. 49XXXXXXXXXXX for Germany.
		if (_text.equals("")) {
			// Just open chat
			intent.setAction(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("whatsapp://send?phone=+".concat(String.valueOf((long)(_number)))));
			startActivity(intent);
		}
		else {
			// Open chat with message
			intent.setAction(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("whatsapp://send?phone=+".concat(String.valueOf((long)(_number))).concat("&text=".concat(_text))));
			startActivity(intent);
		}
	}
	
	
	public void _Toolbar () {
	} @Override public boolean onCreateOptionsMenu (Menu menu){ menu.add(0,0,0, "Refresh").setIcon(R.drawable.ic_refresh_white).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS); menu.add(0,1,1, "Share").setIcon(R.drawable.ic_share_white).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS); return true; }
	
	@Override public boolean onOptionsItemSelected(MenuItem item){ switch (item.getItemId()){ case 0: _refresh(); break; case 1: _Share(); break; } return super.onOptionsItemSelected(item);
	}
	
	
	public void _refresh () {
		listview1.setAdapter(new Listview1Adapter(store_listmap));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		_Toast("ffffff", "0d47a1", "Refresh STORE'S");
	}
	
	
	public void _Share () {
		shareapp = "KOTRAContacts App\n".concat("\nअपनी ऑनलाइन दुकान बनाएं और व्यापार बढ़ाएं दुकान बनाने के लिए नीचे दिए लिंक पर क्लिक करें।\n\n📲 Free Download Now\nhttp://www.kotracontacts.in/2020/05/blog-post.html?m=1");
		Intent i = new Intent(android.content.Intent.ACTION_SEND);i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT,shareapp); startActivity(Intent.createChooser(i,"Click to Share"));
	}
	
	
	public void _refresh_listmap () {
		final androidx.swiperefreshlayout.widget.SwipeRefreshLayout
		 sr = new androidx.swiperefreshlayout.widget.SwipeRefreshLayout
		(this);
		sr.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.MATCH_PARENT));
		list_linear.addView(sr);
		list_linear.removeView(listview1);
		list_linear.post(new Runnable() {
			@Override public void run() {
				sr.addView(listview1);
			}
		});
		
		sr.setOnRefreshListener( new androidx.swiperefreshlayout.widget.SwipeRefreshLayout
		.OnRefreshListener() {
			@Override public void onRefresh() {
				STORE_DB.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						store_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								store_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						NETWORK.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _NETWORK_request_listener);
						listview1.setAdapter(new Listview1Adapter(store_listmap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						sr.setRefreshing(false);
						_Toast("ffffff", "0d47a1", "Refresh successful");
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}}
		);
	}
	
	
	public void _UpdateApp (final String _packageName, final DatabaseReference _ver) {
		package_name = _packageName;
		try {
			android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo( package_name, android.content.pm.PackageManager.GET_ACTIVITIES);
			your_version = pinfo.versionName; }
		catch (Exception e){ showMessage(e.toString()); }
		DatabaseReference rootRef = _firebase.getReference(); rootRef.child("version").addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if (snapshot.exists()) { } else {
					map = new HashMap<>();
					map.put("v", your_version);
					ver.child("app").updateChildren(map);
					map.clear();
				} }
			@Override
			public void onCancelled(DatabaseError _error) { } });
	}
	
	
	public void _UPDATE (final String _title, final String _message, final String _link, final DatabaseReference _ver) {
		
	}
	
	
	public void _NewTapTarget (final View _view, final String _title, final String _msg, final String _bgcolor) {
		TapTargetView.showFor(DashboardActivity.this,
		TapTarget.forView(_view, _title, _msg)
		.outerCircleColorInt(Color.parseColor(_bgcolor))
		.outerCircleAlpha(0.96f)
		.targetCircleColorInt(Color.parseColor("#FFFFFF"))
		.titleTextSize(25)
		.titleTextColorInt(Color.parseColor("#FFFFFF"))
		.descriptionTextSize(18)
		.descriptionTextColor(android.R.color.white)
		.textColorInt(Color.parseColor("#FFFFFF"))
		.textTypeface(Typeface.SANS_SERIF)
		.dimColor(android.R.color.black)
		.drawShadow(true)
		.cancelable(true)
		.tintTarget(true)
		.transparentTarget(true)
		//.icon(Drawable)
		.targetRadius(60),
		
		//LISTENER//
		
		new TapTargetView.Listener() {
			@Override
			public void onTargetClick(TapTargetView view) {
				//ON CLICKED//
				super.onTargetClick(view);
			}
		});
		//Enseña el TapTarget
	}
	static class UiUtil {
		    UiUtil() {
			    }
		    static int dp(Context context, int val) {
			        return (int) TypedValue.applyDimension(
			                TypedValue.COMPLEX_UNIT_DIP, val, context.getResources().getDisplayMetrics());
			    }
		    static int sp(Context context, int val) {
			        return (int) TypedValue.applyDimension(
			                TypedValue.COMPLEX_UNIT_SP, val, context.getResources().getDisplayMetrics());
			    }
		    static int themeIntAttr(Context context, String attr) {
			        final android.content.res.Resources.Theme theme = context.getTheme();
			        if (theme == null) {
				            return -1;
				        }
			        final TypedValue value = new TypedValue();
			        final int id = context.getResources().getIdentifier(attr, "attr", context.getPackageName());
			
			        if (id == 0) {
				            // Not found
				            return -1;
				        }
			        theme.resolveAttribute(id, value, true);
			        return value.data;
			    }
		    static int setAlpha(int argb, float alpha) {
			        if (alpha > 1.0f) {
				            alpha = 1.0f;
				        } else if (alpha <= 0.0f) {
				            alpha = 0.0f;
				        }
			        return ((int) ((argb >>> 24) * alpha) << 24) | (argb & 0x00FFFFFF);
			    }
	}
	static class FloatValueAnimatorBuilder {
		
		    private final ValueAnimator animator;
		
		    private EndListener endListener;
		
		    interface UpdateListener {
			        void onUpdate(float lerpTime);
			    }
		    interface EndListener {
			        void onEnd();
			    }
		    protected FloatValueAnimatorBuilder() {
			        this(false);
			    }
		    FloatValueAnimatorBuilder(boolean reverse) {
			        if (reverse) {
				            this.animator = ValueAnimator.ofFloat(1.0f, 0.0f);
				        } else {
				            this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
				        }
			    }
		    public FloatValueAnimatorBuilder delayBy(long millis) {
			        animator.setStartDelay(millis);
			        return this;
			    }
		    public FloatValueAnimatorBuilder duration(long millis) {
			        animator.setDuration(millis);
			        return this;
			    }
		    public FloatValueAnimatorBuilder interpolator(TimeInterpolator lerper) {
			        animator.setInterpolator(lerper);
			        return this;
			    }
		    public FloatValueAnimatorBuilder repeat(int times) {
			        animator.setRepeatCount(times);
			        return this;
			    }
		    public FloatValueAnimatorBuilder onUpdate(final UpdateListener listener) {
			        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				            @Override
				            public void onAnimationUpdate(ValueAnimator animation) {
					                listener.onUpdate((float) animation.getAnimatedValue());
					            }
				        });
			        return this;
			    }
		    public FloatValueAnimatorBuilder onEnd(final EndListener listener) {
			        this.endListener = listener;
			        return this;
			    }
		    public ValueAnimator build() {
			        if (endListener != null) {
				            animator.addListener(new AnimatorListenerAdapter() {
					                @Override
					                public void onAnimationEnd(Animator animation) {
						                    endListener.onEnd();
						                }
					            });
				        }
			        return animator;
			    }
	}
	
	static class ReflectUtil {
		    ReflectUtil() {
			    }
		    static Object getPrivateField(Object source, String fieldName)
		            throws NoSuchFieldException, IllegalAccessException {
			        final java.lang.reflect.Field objectField = source.getClass().getDeclaredField(fieldName);
			        objectField.setAccessible(true);
			        return objectField.get(source);
			    }
	}
	static class TapTarget extends Activity {
		    final CharSequence title;
		    final CharSequence description;
		    float outerCircleAlpha = 0.96f;
		    int targetRadius = 44;
		    Rect bounds;
		    android.graphics.drawable.Drawable icon;
		    Typeface titleTypeface;
		    Typeface descriptionTypeface;
		
		
		    private int outerCircleColorRes = -1;
		    private int targetCircleColorRes = -1;
		    private int dimColorRes = -1;
		    private int titleTextColorRes = -1;
		    private int descriptionTextColorRes = -1;
		
		    private Integer outerCircleColor = null;
		    private Integer targetCircleColor = null;
		    private Integer dimColor = null;
		    private Integer titleTextColor = null;
		    private Integer descriptionTextColor = null;
		
		    private int titleTextDimen = -1;
		    private int descriptionTextDimen = -1;
		    private int titleTextSize = 20;
		    private int descriptionTextSize = 18;
		    int id = -1;
		    boolean drawShadow = false;
		    boolean cancelable = true;
		    boolean tintTarget = true;
		    boolean transparentTarget = false;
		    float descriptionTextAlpha = 0.54f;
		public static TapTarget forView(View view, CharSequence title) {
			        return forView(view, title, null);
			    }
		    public static TapTarget forView(View view, CharSequence title, CharSequence description) {
			        return new ViewTapTarget(view, title, description);
			    }
		    public static TapTarget forBounds(Rect bounds, CharSequence title) {
			        return forBounds(bounds, title, null);
			    }
		    public static TapTarget forBounds(Rect bounds, CharSequence title,  CharSequence description) {
			        return new TapTarget(bounds, title, description);
			    }
		    protected TapTarget(Rect bounds, CharSequence title,  CharSequence description) {
			        this(title, description);
			        if (bounds == null) {
				            throw new IllegalArgumentException("Cannot pass null bounds or title");
				        }
			        this.bounds = bounds;
			    }
		    protected TapTarget(CharSequence title,  CharSequence description) {
			        if (title == null) {
				            throw new IllegalArgumentException("Cannot pass null title");
				        }
			        this.title = title;
			        this.description = description;
			    }
		    public TapTarget transparentTarget(boolean transparent) {
			        this.transparentTarget = transparent;
			        return this;
			    }
		    public TapTarget outerCircleColor( int color) {
			        this.outerCircleColorRes = color;
			        return this;
			    }
		    public TapTarget outerCircleColorInt( int color) {
			        this.outerCircleColor = color;
			        return this;
			    }
		    public TapTarget outerCircleAlpha(float alpha) {
			        if (alpha < 0.0f || alpha > 1.0f) {
				            throw new IllegalArgumentException("Given an invalid alpha value: " + alpha);
				        }
			        this.outerCircleAlpha = alpha;
			        return this;
			    }
		    public TapTarget targetCircleColor( int color) {
			        this.targetCircleColorRes = color;
			        return this;
			    }
		    public TapTarget targetCircleColorInt( int color) {
			        this.targetCircleColor = color;
			        return this;
			    }
		    public TapTarget textColor( int color) {
			        this.titleTextColorRes = color;
			        this.descriptionTextColorRes = color;
			        return this;
			    }
		    public TapTarget textColorInt( int color) {
			        this.titleTextColor = color;
			        this.descriptionTextColor = color;
			        return this;
			    }
		    public TapTarget titleTextColor( int color) {
			        this.titleTextColorRes = color;
			        return this;
			    }
		    public TapTarget titleTextColorInt( int color) {
			        this.titleTextColor = color;
			        return this;
			    }
		    public TapTarget descriptionTextColor( int color) {
			        this.descriptionTextColorRes = color;
			        return this;
			    }
		    public TapTarget descriptionTextColorInt( int color) {
			        this.descriptionTextColor = color;
			        return this;
			    }
		    public TapTarget textTypeface(Typeface typeface) {
			        if (typeface == null) throw new IllegalArgumentException("Cannot use a null typeface");
			        titleTypeface = typeface;
			        descriptionTypeface = typeface;
			        return this;
			    }
		    public TapTarget titleTypeface(Typeface titleTypeface) {
			        if (titleTypeface == null) throw new IllegalArgumentException("Cannot use a null typeface");
			        this.titleTypeface = titleTypeface;
			        return this;
			    }
		    public TapTarget descriptionTypeface(Typeface descriptionTypeface) {
			        if (descriptionTypeface == null) throw new IllegalArgumentException("Cannot use a null typeface");
			        this.descriptionTypeface = descriptionTypeface;
			        return this;
			    }
		    public TapTarget titleTextSize(int sp) {
			        if (sp < 0) throw new IllegalArgumentException("Given negative text size");
			        this.titleTextSize = sp;
			        return this;
			    }
		    public TapTarget descriptionTextSize(int sp) {
			        if (sp < 0) throw new IllegalArgumentException("Given negative text size");
			        this.descriptionTextSize = sp;
			        return this;
			    }
		    public TapTarget titleTextDimen( int dimen) {
			        this.titleTextDimen = dimen;
			        return this;
			    }
		    public TapTarget descriptionTextAlpha(float descriptionTextAlpha) {
			        if (descriptionTextAlpha < 0 || descriptionTextAlpha > 1f) {
				            throw new IllegalArgumentException("Given an invalid alpha value: " + descriptionTextAlpha);
				        }
			        this.descriptionTextAlpha = descriptionTextAlpha;
			        return this;
			    }
		    public TapTarget descriptionTextDimen( int dimen) {
			        this.descriptionTextDimen = dimen;
			        return this;
			    }
		    public TapTarget dimColor( int color) {
			        this.dimColorRes = color;
			        return this;
			    }
		    public TapTarget dimColorInt( int color) {
			        this.dimColor = color;
			        return this;
			    }
		    public TapTarget drawShadow(boolean draw) {
			        this.drawShadow = draw;
			        return this;
			    }
		    public TapTarget cancelable(boolean status) {
			        this.cancelable = status;
			        return this;
			    }
		    public TapTarget tintTarget(boolean tint) {
			        this.tintTarget = tint;
			        return this;
			    }
		    public TapTarget icon(android.graphics.drawable.Drawable icon) {
			        return icon(icon, false);
			    }
		    public TapTarget icon(android.graphics.drawable.Drawable icon, boolean hasSetBounds) {
			        if (icon == null) throw new IllegalArgumentException("Cannot use null drawable");
			        this.icon = icon;
			        if (!hasSetBounds) {
				            this.icon.setBounds(new Rect(0, 0, this.icon.getIntrinsicWidth(), this.icon.getIntrinsicHeight()));
				        }
			        return this;
			    }
		    public TapTarget id(int id) {
			        this.id = id;
			        return this;
			    }
		    public TapTarget targetRadius(int targetRadius) {
			        this.targetRadius = targetRadius;
			        return this;
			    }
		    public int id() {
			        return id;
			    }
		    public void onReady(Runnable runnable) {
			        runnable.run();
			    }
		    public Rect bounds() {
			        if (bounds == null) {
				            throw new IllegalStateException("Requesting bounds that are not set! Make sure your target is ready");
				        }
			        return bounds;
			    }
		    Integer outerCircleColorInt(Context context) {
			        return colorResOrInt(context, outerCircleColor, outerCircleColorRes);
			    }
		    Integer targetCircleColorInt(Context context) {
			        return colorResOrInt(context, targetCircleColor, targetCircleColorRes);
			    }
		    Integer dimColorInt(Context context) {
			        return colorResOrInt(context, dimColor, dimColorRes);
			    }
		    Integer titleTextColorInt(Context context) {
			        return colorResOrInt(context, titleTextColor, titleTextColorRes);
			    }
		
		    Integer descriptionTextColorInt(Context context) {
			        return colorResOrInt(context, descriptionTextColor, descriptionTextColorRes);
			    }
		    int titleTextSizePx(Context context) {
			        return dimenOrSize(context, titleTextSize, titleTextDimen);
			    }
		    int descriptionTextSizePx(Context context) {
			        return dimenOrSize(context, descriptionTextSize, descriptionTextDimen);
			    }
		
		    private Integer colorResOrInt(Context context, Integer value,  int resource) {
			        if (resource != -1) {
				            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					                return context.getColor(resource);
					            }
				        }
			        return value;
			    }
		    private int dimenOrSize(Context context, int size,  int dimen) {
			        if (dimen != -1) {
				            return context.getResources().getDimensionPixelSize(dimen);
				        }
			        return UiUtil.sp(context, size);
			    }
	}
	static class TapTargetView extends View {
		    private boolean isDismissed = false;
		    private boolean isDismissing = false;
		    private boolean isInteractable = true;
		
		    final int TARGET_PADDING;
		    final int TARGET_RADIUS;
		    final int TARGET_PULSE_RADIUS;
		    final int TEXT_PADDING;
		    final int TEXT_SPACING;
		    final int TEXT_MAX_WIDTH;
		    final int TEXT_POSITIONING_BIAS;
		    final int CIRCLE_PADDING;
		    final int GUTTER_DIM;
		    final int SHADOW_DIM;
		    final int SHADOW_JITTER_DIM;
		
		
		    final ViewGroup boundingParent;
		    final ViewManager parent;
		    final TapTarget target;
		    final Rect targetBounds;
		
		    final TextPaint titlePaint;
		    final TextPaint descriptionPaint;
		    final Paint outerCirclePaint;
		    final Paint outerCircleShadowPaint;
		    final Paint targetCirclePaint;
		    final Paint targetCirclePulsePaint;
		
		    CharSequence title;
		
		    StaticLayout titleLayout;
		
		    CharSequence description;
		
		    StaticLayout descriptionLayout;
		    boolean isDark;
		    boolean debug;
		    boolean shouldTintTarget;
		    boolean shouldDrawShadow;
		    boolean cancelable;
		    boolean visible;
		
		    // Debug related variables
		
		    SpannableStringBuilder debugStringBuilder;
		
		    DynamicLayout debugLayout;
		
		    TextPaint debugTextPaint;
		
		    Paint debugPaint;
		
		    // Drawing properties
		    Rect drawingBounds;
		    Rect textBounds;
		
		    Path outerCirclePath;
		    float outerCircleRadius;
		    int calculatedOuterCircleRadius;
		    int[] outerCircleCenter;
		    int outerCircleAlpha;
		
		    float targetCirclePulseRadius;
		    int targetCirclePulseAlpha;
		
		    float targetCircleRadius;
		    int targetCircleAlpha;
		
		    int textAlpha;
		    int dimColor;
		
		    float lastTouchX;
		    float lastTouchY;
		
		    int topBoundary;
		    int bottomBoundary;
		
		    Bitmap tintedTarget;
		
		    Listener listener;
		
		
		    ViewOutlineProvider outlineProvider;
		
		    public static TapTargetView showFor(Activity activity, TapTarget target) {
			        return showFor(activity, target, null);
			    }
		
		    public static TapTargetView showFor(Activity activity, TapTarget target, Listener listener) {
			        if (activity == null) throw new IllegalArgumentException("Activity is null");
			
			        final ViewGroup decor = (ViewGroup) activity.getWindow().getDecorView();
			        final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
			                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
			        final ViewGroup content = (ViewGroup) decor.findViewById(android.R.id.content);
			        final TapTargetView tapTargetView = new TapTargetView(activity, decor, content, target, listener);
			        decor.addView(tapTargetView, layoutParams);
			
			        return tapTargetView;
			    }
		
		    public static TapTargetView showFor(Dialog dialog, TapTarget target) {
			        return showFor(dialog, target, null);
			    }
		
		    public static TapTargetView showFor(Dialog dialog, TapTarget target, Listener listener) {
			        if (dialog == null) throw new IllegalArgumentException("Dialog is null");
			
			        final Context context = dialog.getContext();
			        final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
			        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
			        params.type = WindowManager.LayoutParams.TYPE_APPLICATION;
			        params.format = PixelFormat.RGBA_8888;
			        params.flags = 0;
			        params.gravity = Gravity.START | Gravity.TOP;
			        params.x = 0;
			        params.y = 0;
			        params.width = WindowManager.LayoutParams.MATCH_PARENT;
			        params.height = WindowManager.LayoutParams.MATCH_PARENT;
			
			        final TapTargetView tapTargetView = new TapTargetView(context, windowManager, null, target, listener);
			        windowManager.addView(tapTargetView, params);
			
			        return tapTargetView;
			    }
		public static class Listener {
			        /** Signals that the user has clicked inside of the target **/
			        public void onTargetClick(TapTargetView view) {
				            view.dismiss(true);
				        }
			
			        /** Signals that the user has long clicked inside of the target **/
			        public void onTargetLongClick(TapTargetView view) {
				            onTargetClick(view);
				        }
			
			        /** If cancelable, signals that the user has clicked outside of the outer circle **/
			        public void onTargetCancel(TapTargetView view) {
				            view.dismiss(false);
				        }
			
			        /** Signals that the user clicked on the outer circle portion of the tap target **/
			        public void onOuterCircleClick(TapTargetView view) {
				            // no-op as default
				        }
			
			        /**
         * Signals that the tap target has been dismissed
         * @param userInitiated Whether the user caused this action
         *
         *
         */
			        public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
				        }
			    }
		
		    final FloatValueAnimatorBuilder.UpdateListener expandContractUpdateListener = new FloatValueAnimatorBuilder.UpdateListener() {
			        @Override
			        public void onUpdate(float lerpTime) {
				            final float newOuterCircleRadius = calculatedOuterCircleRadius * lerpTime;
				            final boolean expanding = newOuterCircleRadius > outerCircleRadius;
				            if (!expanding) {
					                // When contracting we need to invalidate the old drawing bounds. Otherwise
					                // you will see artifacts as the circle gets smaller
					                calculateDrawingBounds();
					            }
				
				            final float targetAlpha = target.outerCircleAlpha * 255;
				            outerCircleRadius = newOuterCircleRadius;
				            outerCircleAlpha = (int) Math.min(targetAlpha, (lerpTime * 1.5f * targetAlpha));
				            outerCirclePath.reset();
				            outerCirclePath.addCircle(outerCircleCenter[0], outerCircleCenter[1], outerCircleRadius, Path.Direction.CW);
				
				            targetCircleAlpha = (int) Math.min(255.0f, (lerpTime * 1.5f * 255.0f));
				
				            if (expanding) {
					                targetCircleRadius = TARGET_RADIUS * Math.min(1.0f, lerpTime * 1.5f);
					            } else {
					                targetCircleRadius = TARGET_RADIUS * lerpTime;
					                targetCirclePulseRadius *= lerpTime;
					            }
				
				            textAlpha = (int) (delayedLerp(lerpTime, 0.7f) * 255);
				
				            if (expanding) {
					                calculateDrawingBounds();
					            }
				
				            invalidateViewAndOutline(drawingBounds);
				        }
			    };
		
		    final ValueAnimator expandAnimation = new FloatValueAnimatorBuilder()
		            .duration(250)
		            .delayBy(250)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
			                @Override
			                public void onUpdate(float lerpTime) {
				                    expandContractUpdateListener.onUpdate(lerpTime);
				                }
			            })
		            .onEnd(new FloatValueAnimatorBuilder.EndListener() {
			                @Override
			                public void onEnd() {
				                    pulseAnimation.start();
				                    isInteractable = true;
				                }
			            })
		            .build();
		
		    final ValueAnimator pulseAnimation = new FloatValueAnimatorBuilder()
		            .duration(1000)
		            .repeat(ValueAnimator.INFINITE)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
			                @Override
			                public void onUpdate(float lerpTime) {
				                    final float pulseLerp = delayedLerp(lerpTime, 0.5f);
				                    targetCirclePulseRadius = (1.0f + pulseLerp) * TARGET_RADIUS;
				                    targetCirclePulseAlpha = (int) ((1.0f - pulseLerp) * 255);
				                    targetCircleRadius = TARGET_RADIUS + halfwayLerp(lerpTime) * TARGET_PULSE_RADIUS;
				
				                    if (outerCircleRadius != calculatedOuterCircleRadius) {
					                        outerCircleRadius = calculatedOuterCircleRadius;
					                    }
				
				                    calculateDrawingBounds();
				                    invalidateViewAndOutline(drawingBounds);
				                }
			            })
		            .build();
		
		    final ValueAnimator dismissAnimation = new FloatValueAnimatorBuilder(true)
		            .duration(250)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
			                @Override
			                public void onUpdate(float lerpTime) {
				                    expandContractUpdateListener.onUpdate(lerpTime);
				                }
			            })
		            .onEnd(new FloatValueAnimatorBuilder.EndListener() {
			                @Override
			                public void onEnd() {
				                    onDismiss(true);
				                    ViewUtil.removeView(parent, TapTargetView.this);
				                }
			            })
		            .build();
		
		    private final ValueAnimator dismissConfirmAnimation = new FloatValueAnimatorBuilder()
		            .duration(250)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
			                @Override
			                public void onUpdate(float lerpTime) {
				                    final float spedUpLerp = Math.min(1.0f, lerpTime * 2.0f);
				                    outerCircleRadius = calculatedOuterCircleRadius * (1.0f + (spedUpLerp * 0.2f));
				                    outerCircleAlpha = (int) ((1.0f - spedUpLerp) * target.outerCircleAlpha * 255.0f);
				                    outerCirclePath.reset();
				                    outerCirclePath.addCircle(outerCircleCenter[0], outerCircleCenter[1], outerCircleRadius, Path.Direction.CW);
				                    targetCircleRadius = (1.0f - lerpTime) * TARGET_RADIUS;
				                    targetCircleAlpha = (int) ((1.0f - lerpTime) * 255.0f);
				                    targetCirclePulseRadius = (1.0f + lerpTime) * TARGET_RADIUS;
				                    targetCirclePulseAlpha = (int) ((1.0f - lerpTime) * targetCirclePulseAlpha);
				                    textAlpha = (int) ((1.0f - spedUpLerp) * 255.0f);
				                    calculateDrawingBounds();
				                    invalidateViewAndOutline(drawingBounds);
				                }
			            })
		            .onEnd(new FloatValueAnimatorBuilder.EndListener() {
			                @Override
			                public void onEnd() {
				                    onDismiss(true);
				                    ViewUtil.removeView(parent, TapTargetView.this);
				                }
			            })
		            .build();
		
		    private ValueAnimator[] animators = new ValueAnimator[]
		            {expandAnimation, pulseAnimation, dismissConfirmAnimation, dismissAnimation};
		
		    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
		    public TapTargetView(final Context context,
		                         final ViewManager parent,
		                          final ViewGroup boundingParent,
		                         final TapTarget target,
		                          final Listener userListener) {
			        super(context);
			        if (target == null) throw new IllegalArgumentException("Target cannot be null");
			
			        this.target = target;
			        this.parent = parent;
			        this.boundingParent = boundingParent;
			        this.listener = userListener != null ? userListener : new Listener();
			        this.title = target.title;
			        this.description = target.description;
			
			        TARGET_PADDING = UiUtil.dp(context, 20);
			        CIRCLE_PADDING = UiUtil.dp(context, 40);
			        TARGET_RADIUS = UiUtil.dp(context, target.targetRadius);
			        TEXT_PADDING = UiUtil.dp(context, 40);
			        TEXT_SPACING = UiUtil.dp(context, 8);
			        TEXT_MAX_WIDTH = UiUtil.dp(context, 360);
			        TEXT_POSITIONING_BIAS = UiUtil.dp(context, 20);
			        GUTTER_DIM = UiUtil.dp(context, 88);
			        SHADOW_DIM = UiUtil.dp(context, 8);
			        SHADOW_JITTER_DIM = UiUtil.dp(context, 1);
			        TARGET_PULSE_RADIUS = (int) (0.1f * TARGET_RADIUS);
			
			        outerCirclePath = new Path();
			        targetBounds = new Rect();
			        drawingBounds = new Rect();
			
			        titlePaint = new TextPaint();
			        titlePaint.setTextSize(target.titleTextSizePx(context));
			        titlePaint.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
			        titlePaint.setAntiAlias(true);
			
			        descriptionPaint = new TextPaint();
			        descriptionPaint.setTextSize(target.descriptionTextSizePx(context));
			        descriptionPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL));
			        descriptionPaint.setAntiAlias(true);
			        descriptionPaint.setAlpha((int) (0.54f * 255.0f));
			
			        outerCirclePaint = new Paint();
			        outerCirclePaint.setAntiAlias(true);
			        outerCirclePaint.setAlpha((int) (target.outerCircleAlpha * 255.0f));
			
			        outerCircleShadowPaint = new Paint();
			        outerCircleShadowPaint.setAntiAlias(true);
			        outerCircleShadowPaint.setAlpha(50);
			        outerCircleShadowPaint.setStyle(Paint.Style.STROKE);
			        outerCircleShadowPaint.setStrokeWidth(SHADOW_JITTER_DIM);
			        outerCircleShadowPaint.setColor(Color.BLACK);
			
			        targetCirclePaint = new Paint();
			        targetCirclePaint.setAntiAlias(true);
			
			        targetCirclePulsePaint = new Paint();
			        targetCirclePulsePaint.setAntiAlias(true);
			
			        applyTargetOptions(context);
			
			        globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
				            @Override
				            public void onGlobalLayout() {
					                if (isDismissing) {
						                    return;
						                }
					                updateTextLayouts();
					                target.onReady(new Runnable() {
						                    @Override
						                    public void run() {
							                        final int[] offset = new int[2];
							
							                        targetBounds.set(target.bounds());
							
							                        getLocationOnScreen(offset);
							                        targetBounds.offset(-offset[0], -offset[1]);
							
							                        if (boundingParent != null) {
								                            final WindowManager windowManager
								                                    = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
								                            final DisplayMetrics displayMetrics = new DisplayMetrics();
								                            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
								
								                            final Rect rect = new Rect();
								                            boundingParent.getWindowVisibleDisplayFrame(rect);
								
								                            // We bound the boundaries to be within the screen's coordinates to
								                            // handle the case where the layout bounds do not match
								                            // (like when FLAG_LAYOUT_NO_LIMITS is specified)
								                            topBoundary = Math.max(0, rect.top);
								                            bottomBoundary = Math.min(rect.bottom, displayMetrics.heightPixels);
								                        }
							
							                        drawTintedTarget();
							                        requestFocus();
							                        calculateDimensions();
							
							                        startExpandAnimation();
							                    }
						                });
					            }
				        };
			
			        getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
			
			        setFocusableInTouchMode(true);
			        setClickable(true);
			        setOnClickListener(new OnClickListener() {
				            @Override
				            public void onClick(View v) {
					                if (listener == null || outerCircleCenter == null || !isInteractable) return;
					
					                final boolean clickedInTarget =
					                        distance(targetBounds.centerX(), targetBounds.centerY(), (int) lastTouchX, (int) lastTouchY) <= targetCircleRadius;
					                final double distanceToOuterCircleCenter = distance(outerCircleCenter[0], outerCircleCenter[1],
					                        (int) lastTouchX, (int) lastTouchY);
					                final boolean clickedInsideOfOuterCircle = distanceToOuterCircleCenter <= outerCircleRadius;
					
					                if (clickedInTarget) {
						                    isInteractable = false;
						                    listener.onTargetClick(TapTargetView.this);
						                } else if (clickedInsideOfOuterCircle) {
						                    listener.onOuterCircleClick(TapTargetView.this);
						                } else if (cancelable) {
						                    isInteractable = false;
						                    listener.onTargetCancel(TapTargetView.this);
						                }
					            }
				        });
			
			        setOnLongClickListener(new OnLongClickListener() {
				            @Override
				            public boolean onLongClick(View v) {
					                if (listener == null) return false;
					
					                if (targetBounds.contains((int) lastTouchX, (int) lastTouchY)) {
						                    listener.onTargetLongClick(TapTargetView.this);
						                    return true;
						                }
					
					                return false;
					            }
				        });
			    }
		
		    private void startExpandAnimation() {
			        if (!visible) {
				            isInteractable = false;
				            expandAnimation.start();
				            visible = true;
				        }
			    }
		
		    protected void applyTargetOptions(Context context) {
			        shouldTintTarget = target.tintTarget;
			        shouldDrawShadow = target.drawShadow;
			        cancelable = target.cancelable;
			
			        // We can't clip out portions of a view outline, so if the user specified a transparent
			        // target, we need to fallback to drawing a jittered shadow approximation
			        if (shouldDrawShadow && Build.VERSION.SDK_INT >= 21 && !target.transparentTarget) {
				            outlineProvider = new ViewOutlineProvider() {
					                @Override
					                public void getOutline(View view, Outline outline) {
						                    if (outerCircleCenter == null) return;
						                    outline.setOval(
						                            (int) (outerCircleCenter[0] - outerCircleRadius), (int) (outerCircleCenter[1] - outerCircleRadius),
						                            (int) (outerCircleCenter[0] + outerCircleRadius), (int) (outerCircleCenter[1] + outerCircleRadius));
						                    outline.setAlpha(outerCircleAlpha / 255.0f);
						                    if (Build.VERSION.SDK_INT >= 22) {
							                        outline.offset(0, SHADOW_DIM);
							                    }
						                }
					            };
				
				            setOutlineProvider(outlineProvider);
				            setElevation(SHADOW_DIM);
				        }
			
			        if (shouldDrawShadow && outlineProvider == null && Build.VERSION.SDK_INT < 18) {
				            setLayerType(LAYER_TYPE_SOFTWARE, null);
				        } else {
				            setLayerType(LAYER_TYPE_HARDWARE, null);
				        }
			
			        final android.content.res.Resources.Theme theme = context.getTheme();
			        isDark = UiUtil.themeIntAttr(context, "isLightTheme") == 0;
			
			        final Integer outerCircleColor = target.outerCircleColorInt(context);
			        if (outerCircleColor != null) {
				            outerCirclePaint.setColor(outerCircleColor);
				        } else if (theme != null) {
				            outerCirclePaint.setColor(UiUtil.themeIntAttr(context, "colorPrimary"));
				        } else {
				            outerCirclePaint.setColor(Color.WHITE);
				        }
			
			        final Integer targetCircleColor = target.targetCircleColorInt(context);
			        if (targetCircleColor != null) {
				            targetCirclePaint.setColor(targetCircleColor);
				        } else {
				            targetCirclePaint.setColor(isDark ? Color.BLACK : Color.WHITE);
				        }
			
			        if (target.transparentTarget) {
				            targetCirclePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
				        }
			
			        targetCirclePulsePaint.setColor(targetCirclePaint.getColor());
			
			        final Integer targetDimColor = target.dimColorInt(context);
			        if (targetDimColor != null) {
				            dimColor = UiUtil.setAlpha(targetDimColor, 0.3f);
				        } else {
				            dimColor = -1;
				        }
			
			        final Integer titleTextColor = target.titleTextColorInt(context);
			        if (titleTextColor != null) {
				            titlePaint.setColor(titleTextColor);
				        } else {
				            titlePaint.setColor(isDark ? Color.BLACK : Color.WHITE);
				        }
			
			        final Integer descriptionTextColor = target.descriptionTextColorInt(context);
			        if (descriptionTextColor != null) {
				            descriptionPaint.setColor(descriptionTextColor);
				        } else {
				            descriptionPaint.setColor(titlePaint.getColor());
				        }
			
			        if (target.titleTypeface != null) {
				            titlePaint.setTypeface(target.titleTypeface);
				        }
			
			        if (target.descriptionTypeface != null) {
				            descriptionPaint.setTypeface(target.descriptionTypeface);
				        }
			    }
		
		    @Override
		    protected void onDetachedFromWindow() {
			        super.onDetachedFromWindow();
			        onDismiss(false);
			    }
		
		    void onDismiss(boolean userInitiated) {
			        if (isDismissed) return;
			
			        isDismissing = false;
			        isDismissed = true;
			
			        for (final ValueAnimator animator : animators) {
				            animator.cancel();
				            animator.removeAllUpdateListeners();
				        }
			        ViewUtil.removeOnGlobalLayoutListener(getViewTreeObserver(), globalLayoutListener);
			        visible = false;
			
			        if (listener != null) {
				            listener.onTargetDismissed(this, userInitiated);
				        }
			    }
		
		    @Override
		    protected void onDraw(Canvas c) {
			        if (isDismissed || outerCircleCenter == null) return;
			
			        if (topBoundary > 0 && bottomBoundary > 0) {
				            c.clipRect(0, topBoundary, getWidth(), bottomBoundary);
				        }
			
			        if (dimColor != -1) {
				            c.drawColor(dimColor);
				        }
			
			        int saveCount;
			        outerCirclePaint.setAlpha(outerCircleAlpha);
			        if (shouldDrawShadow && outlineProvider == null) {
				            saveCount = c.save();
				            {
					                c.clipPath(outerCirclePath, Region.Op.DIFFERENCE);
					                drawJitteredShadow(c);
					            }
				            c.restoreToCount(saveCount);
				        }
			        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1], outerCircleRadius, outerCirclePaint);
			
			        targetCirclePaint.setAlpha(targetCircleAlpha);
			        if (targetCirclePulseAlpha > 0) {
				            targetCirclePulsePaint.setAlpha(targetCirclePulseAlpha);
				            c.drawCircle(targetBounds.centerX(), targetBounds.centerY(),
				                    targetCirclePulseRadius, targetCirclePulsePaint);
				        }
			        c.drawCircle(targetBounds.centerX(), targetBounds.centerY(),
			                targetCircleRadius, targetCirclePaint);
			
			        saveCount = c.save();
			        {
				            c.translate(textBounds.left, textBounds.top);
				            titlePaint.setAlpha(textAlpha);
				            if (titleLayout != null) {
					                titleLayout.draw(c);
					            }
				
				            if (descriptionLayout != null && titleLayout != null) {
					                c.translate(0, titleLayout.getHeight() + TEXT_SPACING);
					                descriptionPaint.setAlpha((int) (target.descriptionTextAlpha * textAlpha));
					                descriptionLayout.draw(c);
					            }
				        }
			        c.restoreToCount(saveCount);
			
			        saveCount = c.save();
			        {
				            if (tintedTarget != null) {
					                c.translate(targetBounds.centerX() - tintedTarget.getWidth() / 2,
					                        targetBounds.centerY() - tintedTarget.getHeight() / 2);
					                c.drawBitmap(tintedTarget, 0, 0, targetCirclePaint);
					            } else if (target.icon != null) {
					                c.translate(targetBounds.centerX() - target.icon.getBounds().width() / 2,
					                        targetBounds.centerY() - target.icon.getBounds().height() / 2);
					                target.icon.setAlpha(targetCirclePaint.getAlpha());
					                target.icon.draw(c);
					            }
				        }
			        c.restoreToCount(saveCount);
			
			        if (debug) {
				            drawDebugInformation(c);
				        }
			    }
		
		    @Override
		    public boolean onTouchEvent(MotionEvent e) {
			        lastTouchX = e.getX();
			        lastTouchY = e.getY();
			        return super.onTouchEvent(e);
			    }
		
		    @Override
		    public boolean onKeyDown(int keyCode, KeyEvent event) {
			        if (isVisible() && cancelable && keyCode == KeyEvent.KEYCODE_BACK) {
				            event.startTracking();
				            return true;
				        }
			
			        return false;
			    }
		
		    @Override
		    public boolean onKeyUp(int keyCode, KeyEvent event) {
			        if (isVisible() && isInteractable && cancelable
			                && keyCode == KeyEvent.KEYCODE_BACK && event.isTracking() && !event.isCanceled()) {
				            isInteractable = false;
				
				            if (listener != null) {
					                listener.onTargetCancel(this);
					            } else {
					                new Listener().onTargetCancel(this);
					            }
				
				            return true;
				        }
			
			        return false;
			    }
		
		    /**
     * Dismiss this view
     * @param tappedTarget If the user tapped the target or not
     *                     (results in different dismiss animations)
     */
		    public void dismiss(boolean tappedTarget) {
			        isDismissing = true;
			        pulseAnimation.cancel();
			        expandAnimation.cancel();
			        if (tappedTarget) {
				            dismissConfirmAnimation.start();
				        } else {
				            dismissAnimation.start();
				        }
			    }
		
		    /** Specify whether to draw a wireframe around the view, useful for debugging **/
		    public void setDrawDebug(boolean status) {
			        if (debug != status) {
				            debug = status;
				            postInvalidate();
				        }
			    }
		
		    /** Returns whether this view is visible or not **/
		    public boolean isVisible() {
			        return !isDismissed && visible;
			    }
		
		    void drawJitteredShadow(Canvas c) {
			        final float baseAlpha = 0.20f * outerCircleAlpha;
			        outerCircleShadowPaint.setStyle(Paint.Style.FILL_AND_STROKE);
			        outerCircleShadowPaint.setAlpha((int) baseAlpha);
			        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1] + SHADOW_DIM, outerCircleRadius, outerCircleShadowPaint);
			        outerCircleShadowPaint.setStyle(Paint.Style.STROKE);
			        final int numJitters = 7;
			        for (int i = numJitters - 1; i > 0; --i) {
				            outerCircleShadowPaint.setAlpha((int) ((i / (float) numJitters) * baseAlpha));
				            c.drawCircle(outerCircleCenter[0], outerCircleCenter[1] + SHADOW_DIM ,
				                    outerCircleRadius + (numJitters - i) * SHADOW_JITTER_DIM , outerCircleShadowPaint);
				        }
			    }
		
		    void drawDebugInformation(Canvas c) {
			        if (debugPaint == null) {
				            debugPaint = new Paint();
				            debugPaint.setARGB(255, 255, 0, 0);
				            debugPaint.setStyle(Paint.Style.STROKE);
				            debugPaint.setStrokeWidth(UiUtil.dp(getContext(), 1));
				        }
			
			        if (debugTextPaint == null) {
				            debugTextPaint = new TextPaint();
				            debugTextPaint.setColor(0xFFFF0000);
				            debugTextPaint.setTextSize(UiUtil.sp(getContext(), 16));
				        }
			
			        // Draw wireframe
			        debugPaint.setStyle(Paint.Style.STROKE);
			        c.drawRect(textBounds, debugPaint);
			        c.drawRect(targetBounds, debugPaint);
			        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1], 10, debugPaint);
			        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1], calculatedOuterCircleRadius - CIRCLE_PADDING, debugPaint);
			        c.drawCircle(targetBounds.centerX(), targetBounds.centerY(), TARGET_RADIUS + TARGET_PADDING, debugPaint);
			
			        // Draw positions and dimensions
			        debugPaint.setStyle(Paint.Style.FILL);
			        final String debugText =
			                "Text bounds: " + textBounds.toShortString() + "\n" + "Target bounds: " + targetBounds.toShortString() + "\n" + "Center: " + outerCircleCenter[0] + " " + outerCircleCenter[1] + "\n" + "View size: " + getWidth() + " " + getHeight() + "\n" + "Target bounds: " + targetBounds.toShortString();
			
			        if (debugStringBuilder == null) {
				            debugStringBuilder = new SpannableStringBuilder(debugText);
				        } else {
				            debugStringBuilder.clear();
				            debugStringBuilder.append(debugText);
				        }
			
			        if (debugLayout == null) {
				            debugLayout = new DynamicLayout(debugText, debugTextPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
				        }
			
			        final int saveCount = c.save();
			        {
				            debugPaint.setARGB(220, 0, 0, 0);
				            c.translate(0.0f, topBoundary);
				            c.drawRect(0.0f, 0.0f, debugLayout.getWidth(), debugLayout.getHeight(), debugPaint);
				            debugPaint.setARGB(255, 255, 0, 0);
				            debugLayout.draw(c);
				        }
			        c.restoreToCount(saveCount);
			    }
		
		    void drawTintedTarget() {
			        final android.graphics.drawable.Drawable icon = target.icon;
			        if (!shouldTintTarget || icon == null) {
				            tintedTarget = null;
				            return;
				        }
			
			        if (tintedTarget != null) return;
			
			        tintedTarget = Bitmap.createBitmap(icon.getIntrinsicWidth(), icon.getIntrinsicHeight(),
			                Bitmap.Config.ARGB_8888);
			        final Canvas canvas = new Canvas(tintedTarget);
			        icon.setColorFilter(new PorterDuffColorFilter(
			                outerCirclePaint.getColor(), PorterDuff.Mode.SRC_ATOP));
			        icon.draw(canvas);
			        icon.setColorFilter(null);
			    }
		
		    void updateTextLayouts() {
			        final int textWidth = Math.min(getWidth(), TEXT_MAX_WIDTH) - TEXT_PADDING * 2;
			        if (textWidth <= 0) {
				            return;
				        }
			
			        titleLayout = new StaticLayout(title, titlePaint, textWidth,
			                Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
			
			        if (description != null) {
				            descriptionLayout = new StaticLayout(description, descriptionPaint, textWidth,
				                    Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
				        } else {
				            descriptionLayout = null;
				        }
			    }
		
		    float halfwayLerp(float lerp) {
			        if (lerp < 0.5f) {
				            return lerp / 0.5f;
				        }
			
			        return (1.0f - lerp) / 0.5f;
			    }
		
		    float delayedLerp(float lerp, float threshold) {
			        if (lerp < threshold) {
				            return 0.0f;
				        }
			
			        return (lerp - threshold) / (1.0f - threshold);
			    }
		
		    void calculateDimensions() {
			        textBounds = getTextBounds();
			        outerCircleCenter = getOuterCircleCenterPoint();
			        calculatedOuterCircleRadius = getOuterCircleRadius(outerCircleCenter[0], outerCircleCenter[1], textBounds, targetBounds);
			    }
		
		    void calculateDrawingBounds() {
			        if (outerCircleCenter == null) {
				            // Called dismiss before we got a chance to display the tap target
				            // So we have no center -> cant determine the drawing bounds
				            return;
				        }
			        drawingBounds.left = (int) Math.max(0, outerCircleCenter[0] - outerCircleRadius);
			        drawingBounds.top = (int) Math.min(0, outerCircleCenter[1] - outerCircleRadius);
			        drawingBounds.right = (int) Math.min(getWidth(),
			                outerCircleCenter[0] + outerCircleRadius + CIRCLE_PADDING);
			        drawingBounds.bottom = (int) Math.min(getHeight(),
			                outerCircleCenter[1] + outerCircleRadius + CIRCLE_PADDING);
			    }
		
		    int getOuterCircleRadius(int centerX, int centerY, Rect textBounds, Rect targetBounds) {
			        final int targetCenterX = targetBounds.centerX();
			        final int targetCenterY = targetBounds.centerY();
			        final int expandedRadius = (int) (1.1f * TARGET_RADIUS);
			        final Rect expandedBounds = new Rect(targetCenterX, targetCenterY, targetCenterX, targetCenterY);
			        expandedBounds.inset(-expandedRadius, -expandedRadius);
			
			        final int textRadius = maxDistanceToPoints(centerX, centerY, textBounds);
			        final int targetRadius = maxDistanceToPoints(centerX, centerY, expandedBounds);
			        return Math.max(textRadius, targetRadius) + CIRCLE_PADDING;
			    }
		
		    Rect getTextBounds() {
			        final int totalTextHeight = getTotalTextHeight();
			        final int totalTextWidth = getTotalTextWidth();
			
			        final int possibleTop = targetBounds.centerY() - TARGET_RADIUS - TARGET_PADDING - totalTextHeight;
			        final int top;
			        if (possibleTop > topBoundary) {
				            top = possibleTop;
				        } else {
				            top = targetBounds.centerY() + TARGET_RADIUS + TARGET_PADDING;
				        }
			
			        final int relativeCenterDistance = (getWidth() / 2) - targetBounds.centerX();
			        final int bias = relativeCenterDistance < 0 ? -TEXT_POSITIONING_BIAS : TEXT_POSITIONING_BIAS;
			        final int left = Math.max(TEXT_PADDING, targetBounds.centerX() - bias - totalTextWidth);
			        final int right = Math.min(getWidth() - TEXT_PADDING, left + totalTextWidth);
			        return new Rect(left, top, right, top + totalTextHeight);
			    }
		
		    int[] getOuterCircleCenterPoint() {
			        if (inGutter(targetBounds.centerY())) {
				            return new int[]{targetBounds.centerX(), targetBounds.centerY()};
				        }
			
			        final int targetRadius = Math.max(targetBounds.width(), targetBounds.height()) / 2 + TARGET_PADDING;
			        final int totalTextHeight = getTotalTextHeight();
			
			        final boolean onTop = targetBounds.centerY() - TARGET_RADIUS - TARGET_PADDING - totalTextHeight > 0;
			
			        final int left = Math.min(textBounds.left, targetBounds.left - targetRadius);
			        final int right = Math.max(textBounds.right, targetBounds.right + targetRadius);
			        final int titleHeight = titleLayout == null ? 0 : titleLayout.getHeight();
			        final int centerY = onTop ?
			                targetBounds.centerY() - TARGET_RADIUS - TARGET_PADDING - totalTextHeight + titleHeight
			                :
			                targetBounds.centerY() + TARGET_RADIUS + TARGET_PADDING + titleHeight;
			
			        return new int[] { (left + right) / 2, centerY };
			    }
		
		    int getTotalTextHeight() {
			        if (titleLayout == null) {
				            return 0;
				        }
			
			        if (descriptionLayout == null) {
				            return titleLayout.getHeight() + TEXT_SPACING;
				        }
			
			        return titleLayout.getHeight() + descriptionLayout.getHeight() + TEXT_SPACING;
			    }
		
		    int getTotalTextWidth() {
			        if (titleLayout == null) {
				            return 0;
				        }
			
			        if (descriptionLayout == null) {
				            return titleLayout.getWidth();
				        }
			
			        return Math.max(titleLayout.getWidth(), descriptionLayout.getWidth());
			    }
		    boolean inGutter(int y) {
			        if (bottomBoundary > 0) {
				            return y < GUTTER_DIM || y > bottomBoundary - GUTTER_DIM;
				        } else {
				            return y < GUTTER_DIM || y > getHeight() - GUTTER_DIM;
				        }
			    }
		    int maxDistanceToPoints(int x1, int y1, Rect bounds) {
			        final double tl = distance(x1, y1, bounds.left, bounds.top);
			        final double tr = distance(x1, y1, bounds.right, bounds.top);
			        final double bl = distance(x1, y1, bounds.left, bounds.bottom);
			        final double br = distance(x1, y1, bounds.right, bounds.bottom);
			        return (int) Math.max(tl, Math.max(tr, Math.max(bl, br)));
			    }
		    double distance(int x1, int y1, int x2, int y2) {
			        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			    }
		    void invalidateViewAndOutline(Rect bounds) {
			        invalidate(bounds);
			        if (outlineProvider != null && Build.VERSION.SDK_INT >= 21) {
				            invalidateOutline();
				        }
			    }
	}
	
	static class ViewUtil {
		
		    ViewUtil() {}
		
		    private static boolean isLaidOut(View view) {
			        return true;
			    }
		    static void onLaidOut(final View view, final Runnable runnable) {
			        if (isLaidOut(view)) {
				            runnable.run();
				            return;
				        }
			        final ViewTreeObserver observer = view.getViewTreeObserver();
			        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
				            @Override
				            public void onGlobalLayout() {
					                final ViewTreeObserver trueObserver;
					                if (observer.isAlive()) {
						                    trueObserver = observer;
						                } else {
						                    trueObserver = view.getViewTreeObserver();
						                }
					                removeOnGlobalLayoutListener(trueObserver, this);
					                runnable.run();
					            }
				        });
			    }
		    @SuppressWarnings("deprecation")
		    static void removeOnGlobalLayoutListener(ViewTreeObserver observer,
		                                             ViewTreeObserver.OnGlobalLayoutListener listener) {
			        if (Build.VERSION.SDK_INT >= 16) {
				            observer.removeOnGlobalLayoutListener(listener);
				        } else {
				            observer.removeGlobalOnLayoutListener(listener);
				        }
			    }
		    static void removeView(ViewManager parent, View child) {
			        if (parent == null || child == null) {
				            return;
				        }
			        try {
				            parent.removeView(child);
				        } catch (Exception ignored) {
				        }
			    }
	}
	
	static class ViewTapTarget extends TapTarget {
		    final View view;
		
		    ViewTapTarget(View view, CharSequence title,  CharSequence description) {
			        super(title, description);
			        if (view == null) {
				            throw new IllegalArgumentException("Given null view to target");
				        }
			        this.view = view;
			    }
		
		    @Override
		    public void onReady(final Runnable runnable) {
			        ViewUtil.onLaidOut(view, new Runnable() {
				            @Override
				            public void run() {
					                // Cache bounds
					                final int[] location = new int[2];
					                view.getLocationOnScreen(location);
					                bounds = new Rect(location[0], location[1],
					                        location[0] + view.getWidth(), location[1] + view.getHeight());
					
					                if (icon == null && view.getWidth() > 0 && view.getHeight() > 0) {
						                    final Bitmap viewBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
						                    final Canvas canvas = new Canvas(viewBitmap);
						                    view.draw(canvas);
						                    icon = new android.graphics.drawable.BitmapDrawable(view.getContext().getResources(), viewBitmap);
						                    icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
						                }
					
					                runnable.run();
					            }
				        });
			    }
	}
	
	
	public void _card_style (final View _view, final double _shadow, final double _rounds, final String _colour) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_colour));
		gd.setCornerRadius((int)_rounds);
		_view.setBackground(gd);
		_view.setElevation((int)_shadow);
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
				_view = _inflater.inflate(R.layout.custom_store, null);
			}
			
			final LinearLayout linear25 = (LinearLayout) _view.findViewById(R.id.linear25);
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final LinearLayout linear10 = (LinearLayout) _view.findViewById(R.id.linear10);
			final LinearLayout linear19 = (LinearLayout) _view.findViewById(R.id.linear19);
			final TextView store_name_text = (TextView) _view.findViewById(R.id.store_name_text);
			final LinearLayout invisible_linear22 = (LinearLayout) _view.findViewById(R.id.invisible_linear22);
			final LinearLayout linear23 = (LinearLayout) _view.findViewById(R.id.linear23);
			final LinearLayout linear24 = (LinearLayout) _view.findViewById(R.id.linear24);
			final TextView textview8open = (TextView) _view.findViewById(R.id.textview8open);
			final TextView upi_textview = (TextView) _view.findViewById(R.id.upi_textview);
			final ImageView pp_imageview = (ImageView) _view.findViewById(R.id.pp_imageview);
			final LinearLayout linear11 = (LinearLayout) _view.findViewById(R.id.linear11);
			final LinearLayout linear16 = (LinearLayout) _view.findViewById(R.id.linear16);
			final LinearLayout linear17 = (LinearLayout) _view.findViewById(R.id.linear17);
			final TextView textview6 = (TextView) _view.findViewById(R.id.textview6);
			final TextView owner = (TextView) _view.findViewById(R.id.owner);
			final TextView textview7 = (TextView) _view.findViewById(R.id.textview7);
			final TextView email = (TextView) _view.findViewById(R.id.email);
			final ImageView sp_imageview = (ImageView) _view.findViewById(R.id.sp_imageview);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = (LinearLayout) _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = (LinearLayout) _view.findViewById(R.id.linear5);
			final LinearLayout linear6 = (LinearLayout) _view.findViewById(R.id.linear6);
			final LinearLayout linear18 = (LinearLayout) _view.findViewById(R.id.linear18);
			final LinearLayout linear7 = (LinearLayout) _view.findViewById(R.id.linear7);
			final ImageView imageview2 = (ImageView) _view.findViewById(R.id.imageview2);
			final TextView category = (TextView) _view.findViewById(R.id.category);
			final ImageView imageview3 = (ImageView) _view.findViewById(R.id.imageview3);
			final TextView contact_number = (TextView) _view.findViewById(R.id.contact_number);
			final ImageView imageview7 = (ImageView) _view.findViewById(R.id.imageview7);
			final TextView whatsapp_number = (TextView) _view.findViewById(R.id.whatsapp_number);
			final ImageView imageview4 = (ImageView) _view.findViewById(R.id.imageview4);
			final TextView address = (TextView) _view.findViewById(R.id.address);
			final ImageView imageview5 = (ImageView) _view.findViewById(R.id.imageview5);
			final TextView services = (TextView) _view.findViewById(R.id.services);
			final ImageView imageview9 = (ImageView) _view.findViewById(R.id.imageview9);
			final TextView keytext = (TextView) _view.findViewById(R.id.keytext);
			final TextView date_t = (TextView) _view.findViewById(R.id.date_t);
			final Button calling_button = (Button) _view.findViewById(R.id.calling_button);
			final LinearLayout linear12 = (LinearLayout) _view.findViewById(R.id.linear12);
			final Button whatsapp_button = (Button) _view.findViewById(R.id.whatsapp_button);
			final LinearLayout linear13 = (LinearLayout) _view.findViewById(R.id.linear13);
			final Button email_button = (Button) _view.findViewById(R.id.email_button);
			final LinearLayout linear21 = (LinearLayout) _view.findViewById(R.id.linear21);
			final Button pay_button = (Button) _view.findViewById(R.id.pay_button);
			final LinearLayout linear14 = (LinearLayout) _view.findViewById(R.id.linear14);
			final Button share_button = (Button) _view.findViewById(R.id.share_button);
			final LinearLayout linear20 = (LinearLayout) _view.findViewById(R.id.linear20);
			final Button review_button = (Button) _view.findViewById(R.id.review_button);
			final ImageView imageview10 = (ImageView) _view.findViewById(R.id.imageview10);
			final TextView t_view1 = (TextView) _view.findViewById(R.id.t_view1);
			final TextView textview10 = (TextView) _view.findViewById(R.id.textview10);
			final TextView t_extra = (TextView) _view.findViewById(R.id.t_extra);
			final ImageView imageview8 = (ImageView) _view.findViewById(R.id.imageview8);
			final TextView review_t = (TextView) _view.findViewById(R.id.review_t);
			final TextView textview11 = (TextView) _view.findViewById(R.id.textview11);
			final ImageView imageview11 = (ImageView) _view.findViewById(R.id.imageview11);
			final TextView textview12 = (TextView) _view.findViewById(R.id.textview12);
			
			date = store_listmap.get((int)_position).get("date").toString();
			user_key = store_listmap.get((int)_position).get("user key").toString();
			category_str = store_listmap.get((int)_position).get("store category").toString();
			extra = store_listmap.get((int)_position).get("extra").toString();
			upi = store_listmap.get((int)_position).get("upi id").toString();
			contact_number_str = store_listmap.get((int)_position).get("country code").toString().concat(store_listmap.get((int)_position).get("mobile number").toString());
			WhatsApp_number = store_listmap.get((int)_position).get("country code").toString().concat(store_listmap.get((int)_position).get("whatsapp number").toString());
			services_str = store_listmap.get((int)_position).get("store services").toString();
			if (store_listmap.get((int)_position).containsKey("store pp image")) {
				Glide.with(getApplicationContext()).load(Uri.parse(store_listmap.get((int)_position).get("store pp image").toString())).into(pp_imageview);
			}
			else {
				pp_imageview.setImageResource(R.drawable.boy);
			}
			if (store_listmap.get((int)_position).containsKey("store image")) {
				Glide.with(getApplicationContext()).load(Uri.parse(store_listmap.get((int)_position).get("store image").toString())).into(sp_imageview);
			}
			else {
				sp_imageview.setImageResource(R.drawable.icon_kotra2);
			}
			if (store_listmap.get((int)_position).containsKey("email address")) {
				email.setText(store_listmap.get((int)_position).get("email address").toString());
			}
			if (store_listmap.get((int)_position).containsKey("owner name")) {
				owner.setText(store_listmap.get((int)_position).get("owner name").toString());
			}
			if (store_listmap.get((int)_position).containsKey("store name")) {
				store_name_text.setText(store_listmap.get((int)_position).get("store name").toString());
			}
			if (store_listmap.get((int)_position).containsKey("view1")) {
				t_view1.setText(store_listmap.get((int)_position).get("view1").toString());
			}
			if (store_listmap.get((int)_position).containsKey("store number") && (store_listmap.get((int)_position).containsKey("store area") && (store_listmap.get((int)_position).containsKey("store city") && (store_listmap.get((int)_position).containsKey("store state") && store_listmap.get((int)_position).containsKey("store country"))))) {
				textview12.setText(store_listmap.get((int)_position).get("store number").toString().concat(" ".concat(store_listmap.get((int)_position).get("store area").toString().concat(" ".concat(store_listmap.get((int)_position).get("store city").toString().concat(" ".concat(store_listmap.get((int)_position).get("store state").toString().concat(" ".concat(store_listmap.get((int)_position).get("store country").toString())))))))));
			}
			if (review1.containsKey(store_listmap.get((int)_position).get("user key").toString())) {
				review_t.setText(review1.get(store_listmap.get((int)_position).get("user key").toString()).toString());
			}
			else {
				review_t.setText("");
			}
			calling_button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					calling_i.setAction(Intent.ACTION_DIAL);
					calling_i.setData(Uri.parse("tel:".concat(contact_number.getText().toString())));
					startActivity(calling_i);
					_Toast("ffffff", "0d47a1", "Please wait Calling connecting");
				}
			});
			whatsapp_button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					whatsapp_i.setAction(Intent.ACTION_VIEW);
					whatsapp_i.setData(Uri.parse("https://api.whatsapp.com/send?phone=".concat(whatsapp_number.getText().toString())));
					startActivity(whatsapp_i);
					_Toast("ffffff", "0d47a1", "Please wait WhatsApp connecting");
				}
			});
			email_button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					_Send(email_i, email.getText().toString(), store_name_text.getText().toString(), "any help you...?");
					_Toast("ffffff", "0d47a1", "Please wait email connecting");
				}
			});
			share_button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					share = "KOTRA Contacts\n".concat("\nSTORE NAME :- ").concat(store_name_text.getText().toString()).concat("\n\nMOBILE NUMBER :- ".concat(contact_number.getText().toString()).concat("\n\nWHATSAPP NUMBER :- ".concat(whatsapp_number.getText().toString()).concat("\n\nEMAIL ADDRESS :- ".concat(email.getText().toString()).concat("\n\nADDRESS :- ".concat(address.getText().toString()).concat("\n\nSTORE SERVICES :- ".concat(services.getText().toString()).concat("\n\n📲 Free Download Now\nhttp://www.kotracontacts.in/2020/05/app-services.html?m=1"))))));
					Intent i = new Intent(android.content.Intent.ACTION_SEND);i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT,share); startActivity(Intent.createChooser(i,"Click to Share"));
					_Toast("ffffff", "0d47a1", "Shop Details Sharing");
				}
			});
			review_button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					review_i.setAction(Intent.ACTION_VIEW);
					review_i.setClass(getApplicationContext(), ReviewActivity.class);
					review_i.putExtra("user key", store_listmap.get((int)_position).get("user key").toString());
					startActivity(review_i);
					_Toast("ffffff", "0d47a1", "Please give your review");
				}
			});
			pay_button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (upi_textview.getText().toString().equals("")) {
						_Toast("ffffff", "0d47a1", "NO UPI");
					}
					else {
						Intent intent = new Intent();
						intent.setAction(Intent.ACTION_VIEW);
						intent.setData(Uri.parse("upi://pay?pa=".concat(upi_textview.getText().toString().concat("&pn=".concat(store_name_text.getText().toString())))));
						Intent chooser = Intent.createChooser(intent, "use any upi");
						 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
						 { startActivityForResult(chooser, 1, null); }
					}
				}
			});
			textview8open.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					open_i.setAction(Intent.ACTION_VIEW);
					open_i.setClass(getApplicationContext(), ViewStoreActivity.class);
					open_i.putExtra("store pp image", store_listmap.get((int)_position).get("store pp image").toString());
					open_i.putExtra("store image", store_listmap.get((int)_position).get("store image").toString());
					open_i.putExtra("view1", store_listmap.get((int)_position).get("view1").toString());
					open_i.putExtra("review", review_t.getText().toString());
					open_i.putExtra("date", store_listmap.get((int)_position).get("date").toString());
					open_i.putExtra("user key", store_listmap.get((int)_position).get("user key").toString());
					open_i.putExtra("email address", store_listmap.get((int)_position).get("email address").toString());
					open_i.putExtra("owner name", store_listmap.get((int)_position).get("owner name").toString());
					open_i.putExtra("store name", store_listmap.get((int)_position).get("store name").toString());
					open_i.putExtra("store category", store_listmap.get((int)_position).get("store category").toString());
					open_i.putExtra("upi id", store_listmap.get((int)_position).get("upi id").toString());
					open_i.putExtra("contact number", store_listmap.get((int)_position).get("country code").toString().concat(store_listmap.get((int)_position).get("mobile number").toString()));
					open_i.putExtra("whatsapp number", store_listmap.get((int)_position).get("country code").toString().concat(store_listmap.get((int)_position).get("whatsapp number").toString()));
					open_i.putExtra("address", store_listmap.get((int)_position).get("store number").toString().concat(" ".concat(store_listmap.get((int)_position).get("store area").toString().concat(" ".concat(store_listmap.get((int)_position).get("store city").toString().concat(" ".concat(store_listmap.get((int)_position).get("store state").toString().concat(" ".concat(store_listmap.get((int)_position).get("store country").toString())))))))));
					open_i.putExtra("store services", store_listmap.get((int)_position).get("store services").toString());
					startActivity(open_i);
				}
			});
			_card_style(linear25, 30, 100, "#FFFFFF");
			_shape(0, 0, 20, 20, "#0D47A1", "#0D47A1", 8, textview8open);
			_ClickColor(linear1, "#ffffff", "#0D47A1", "#ffffff", "#0D47A1", 8, 100);
			imageview10.setColorFilter(0xFF0D47A1, PorterDuff.Mode.MULTIPLY);
			imageview8.setColorFilter(0xFF0D47A1, PorterDuff.Mode.MULTIPLY);
			imageview11.setColorFilter(0xFF0D47A1, PorterDuff.Mode.MULTIPLY);
			
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