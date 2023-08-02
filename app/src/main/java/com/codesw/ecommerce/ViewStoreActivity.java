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
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.HorizontalScrollView;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.bumptech.glide.Glide;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class ViewStoreActivity extends  AppCompatActivity  { 
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String view1 = "";
	private String user_key = "";
	private HashMap<String, Object> review1 = new HashMap<>();
	private double review_n = 0;
	private String reviews = "";
	private String share = "";
	
	private ArrayList<HashMap<String, Object>> store_listmap = new ArrayList<>();
	
	private TextView textview41;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear11;
	private LinearLayout linear22;
	private ImageView imageview1;
	private TextView store_name;
	private LinearLayout linear3d;
	private ImageView profile_pic;
	private LinearLayout linear23;
	private LinearLayout linear26;
	private LinearLayout linear27;
	private TextView textview16;
	private TextView owner_name;
	private TextView textview2;
	private TextView business_email;
	private LinearLayout linear45;
	private LinearLayout linear5;
	private ImageView imageview15;
	private TextView textview28view;
	private TextView textview27;
	private TextView textview41upi_id;
	private TextView textview41_userkey;
	private ImageView imageview18;
	private TextView textview31reviews;
	private TextView textview32;
	private LinearLayout linear44;
	private LinearLayout linear7;
	private LinearLayout linear32;
	private LinearLayout linear34;
	private LinearLayout linear36;
	private LinearLayout linear46;
	private ImageView imageview17;
	private TextView t_cadegye;
	private LinearLayout linear8;
	private LinearLayout linear42;
	private ImageView imageview5;
	private TextView textview15;
	private TextView textview21call;
	private TextView textview30;
	private TextView textview29wa;
	private LinearLayout linear33;
	private TextView textview6address;
	private ImageView imageview12;
	private TextView textview22;
	private LinearLayout linear35;
	private TextView textview23info;
	private ImageView imageview13;
	private TextView textview24;
	private LinearLayout linear37;
	private TextView textview25date;
	private ImageView imageview14;
	private TextView textview26;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear47;
	private LinearLayout linear48;
	private LinearLayout linear19;
	private LinearLayout linear54;
	private LinearLayout linear55;
	private LinearLayout linear50;
	private LinearLayout linear51;
	private ImageView imageview10;
	private TextView textview21;
	private ImageView imageview25;
	private TextView textview39;
	private ImageView imageview26;
	private TextView textview40;
	private ImageView imageview21;
	private TextView textview35;
	private ImageView imageview22;
	private TextView textview36;
	private LinearLayout linear49;
	private LinearLayout linear53;
	private LinearLayout linear52;
	private ImageView imageview20;
	private TextView textview34;
	private ImageView imageview24;
	private TextView textview38;
	private ImageView imageview23;
	private TextView textview37;
	
	private ObjectAnimator oa = new ObjectAnimator();
	private DatabaseReference STORE_DB = _firebase.getReference("STORE_DB");
	private ChildEventListener _STORE_DB_child_listener;
	private DatabaseReference review_db = _firebase.getReference("review_db");
	private ChildEventListener _review_db_child_listener;
	private Intent review_i = new Intent();
	private Intent calling_i = new Intent();
	private Intent msg_i = new Intent();
	private Intent wa_i = new Intent();
	private Intent intent = new Intent();
	private Intent email_i = new Intent();
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.view_store);
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
		textview41 = (TextView) findViewById(R.id.textview41);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		store_name = (TextView) findViewById(R.id.store_name);
		linear3d = (LinearLayout) findViewById(R.id.linear3d);
		profile_pic = (ImageView) findViewById(R.id.profile_pic);
		linear23 = (LinearLayout) findViewById(R.id.linear23);
		linear26 = (LinearLayout) findViewById(R.id.linear26);
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		textview16 = (TextView) findViewById(R.id.textview16);
		owner_name = (TextView) findViewById(R.id.owner_name);
		textview2 = (TextView) findViewById(R.id.textview2);
		business_email = (TextView) findViewById(R.id.business_email);
		linear45 = (LinearLayout) findViewById(R.id.linear45);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		imageview15 = (ImageView) findViewById(R.id.imageview15);
		textview28view = (TextView) findViewById(R.id.textview28view);
		textview27 = (TextView) findViewById(R.id.textview27);
		textview41upi_id = (TextView) findViewById(R.id.textview41upi_id);
		textview41_userkey = (TextView) findViewById(R.id.textview41_userkey);
		imageview18 = (ImageView) findViewById(R.id.imageview18);
		textview31reviews = (TextView) findViewById(R.id.textview31reviews);
		textview32 = (TextView) findViewById(R.id.textview32);
		linear44 = (LinearLayout) findViewById(R.id.linear44);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear32 = (LinearLayout) findViewById(R.id.linear32);
		linear34 = (LinearLayout) findViewById(R.id.linear34);
		linear36 = (LinearLayout) findViewById(R.id.linear36);
		linear46 = (LinearLayout) findViewById(R.id.linear46);
		imageview17 = (ImageView) findViewById(R.id.imageview17);
		t_cadegye = (TextView) findViewById(R.id.t_cadegye);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear42 = (LinearLayout) findViewById(R.id.linear42);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview15 = (TextView) findViewById(R.id.textview15);
		textview21call = (TextView) findViewById(R.id.textview21call);
		textview30 = (TextView) findViewById(R.id.textview30);
		textview29wa = (TextView) findViewById(R.id.textview29wa);
		linear33 = (LinearLayout) findViewById(R.id.linear33);
		textview6address = (TextView) findViewById(R.id.textview6address);
		imageview12 = (ImageView) findViewById(R.id.imageview12);
		textview22 = (TextView) findViewById(R.id.textview22);
		linear35 = (LinearLayout) findViewById(R.id.linear35);
		textview23info = (TextView) findViewById(R.id.textview23info);
		imageview13 = (ImageView) findViewById(R.id.imageview13);
		textview24 = (TextView) findViewById(R.id.textview24);
		linear37 = (LinearLayout) findViewById(R.id.linear37);
		textview25date = (TextView) findViewById(R.id.textview25date);
		imageview14 = (ImageView) findViewById(R.id.imageview14);
		textview26 = (TextView) findViewById(R.id.textview26);
		hscroll1 = (HorizontalScrollView) findViewById(R.id.hscroll1);
		linear47 = (LinearLayout) findViewById(R.id.linear47);
		linear48 = (LinearLayout) findViewById(R.id.linear48);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear54 = (LinearLayout) findViewById(R.id.linear54);
		linear55 = (LinearLayout) findViewById(R.id.linear55);
		linear50 = (LinearLayout) findViewById(R.id.linear50);
		linear51 = (LinearLayout) findViewById(R.id.linear51);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		textview21 = (TextView) findViewById(R.id.textview21);
		imageview25 = (ImageView) findViewById(R.id.imageview25);
		textview39 = (TextView) findViewById(R.id.textview39);
		imageview26 = (ImageView) findViewById(R.id.imageview26);
		textview40 = (TextView) findViewById(R.id.textview40);
		imageview21 = (ImageView) findViewById(R.id.imageview21);
		textview35 = (TextView) findViewById(R.id.textview35);
		imageview22 = (ImageView) findViewById(R.id.imageview22);
		textview36 = (TextView) findViewById(R.id.textview36);
		linear49 = (LinearLayout) findViewById(R.id.linear49);
		linear53 = (LinearLayout) findViewById(R.id.linear53);
		linear52 = (LinearLayout) findViewById(R.id.linear52);
		imageview20 = (ImageView) findViewById(R.id.imageview20);
		textview34 = (TextView) findViewById(R.id.textview34);
		imageview24 = (ImageView) findViewById(R.id.imageview24);
		textview38 = (TextView) findViewById(R.id.textview38);
		imageview23 = (ImageView) findViewById(R.id.imageview23);
		textview37 = (TextView) findViewById(R.id.textview37);
		network = new RequestNetwork(this);
		
		linear19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				calling_i.setAction(Intent.ACTION_DIAL);
				calling_i.setData(Uri.parse("tel:".concat(textview21call.getText().toString())));
				startActivity(calling_i);
				_Toast("ffffff", "0d47a1", "Please wait connecting");
			}
		});
		
		linear54.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				msg_i.setAction(Intent.ACTION_VIEW);
				msg_i.setData(Uri.parse("sms:".concat(textview21call.getText().toString())));
				startActivity(msg_i);
				_Toast("ffffff", "0d47a1", "Please wait inbox connecting");
			}
		});
		
		linear55.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				wa_i.setAction(Intent.ACTION_VIEW);
				wa_i.setData(Uri.parse("https://api.whatsapp.com/send?phone=".concat(textview29wa.getText().toString())));
				startActivity(wa_i);
				_Toast("ffffff", "0d47a1", "Please wait WhatsApp connecting");
			}
		});
		
		linear50.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (textview41upi_id.getText().toString().equals("")) {
					_Toast("ffffff", "0d47a1", "NO UPI");
				}
				else {
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setData(Uri.parse("upi://pay?pa=".concat(textview41upi_id.getText().toString().concat("&pn=".concat(store_name.getText().toString())))));
					Intent chooser = Intent.createChooser(intent, "use any upi");
					 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
					 { startActivityForResult(chooser, 1, null); }
					_Toast("ffffff", "0d47a1", "select your payment option");
				}
			}
		});
		
		linear51.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Send(email_i, business_email.getText().toString(), store_name.getText().toString(), "any help you...?");
				_Toast("ffffff", "0d47a1", "Please wait email connecting");
			}
		});
		
		linear49.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				share = "KOTRA Contacts\n".concat("\nSTORE NAME :- ").concat(store_name.getText().toString()).concat("\nMOBILE NUMBER :- ".concat(textview21call.getText().toString()).concat("\nWHATSAPP NUMBER :- ".concat(textview29wa.getText().toString()).concat("\nEMAIL ADDRESS :- ".concat(business_email.getText().toString()).concat("\nADDRESS :- ".concat(textview6address.getText().toString()).concat("\nSTORE SERVICES :- ".concat(textview23info.getText().toString()).concat("\n\n📲 Free Download Now\nhttp://www.kotracontacts.in/2020/03/blog-post.html?m=1"))))));
				Intent i = new Intent(android.content.Intent.ACTION_SEND);i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT,share); startActivity(Intent.createChooser(i,"Click to Share"));
				_Toast("ffffff", "0d47a1", "choice your sharing option");
			}
		});
		
		linear53.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Download(getIntent().getStringExtra("store image"), store_name.getText().toString().concat(textview21call.getText().toString()).concat(".png"));
			}
		});
		
		linear52.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				review_i.setAction(Intent.ACTION_VIEW);
				review_i.setClass(getApplicationContext(), ReviewActivity.class);
				review_i.putExtra("user key", user_key);
				startActivity(review_i);
			}
		});
		
		_STORE_DB_child_listener = new ChildEventListener() {
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
		STORE_DB.addChildEventListener(_STORE_DB_child_listener);
		
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
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _network_request_listener);
				textview41.setVisibility(View.GONE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _network_request_listener);
				textview41.setVisibility(View.VISIBLE);
				textview41.setText("No internet connection...");
			}
		};
	}
	
	private void initializeLogic() {
		network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _network_request_listener);
		textview41.setVisibility(View.GONE);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("store image"))).into(imageview1);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("store pp image"))).into(profile_pic);
		textview25date.setText(getIntent().getStringExtra("date"));
		textview41_userkey.setText(getIntent().getStringExtra("user key"));
		business_email.setText(getIntent().getStringExtra("email address"));
		owner_name.setText(getIntent().getStringExtra("owner name"));
		textview28view.setText(getIntent().getStringExtra("view1"));
		textview21call.setText(getIntent().getStringExtra("contact number"));
		textview29wa.setText(getIntent().getStringExtra("whatsapp number"));
		textview6address.setText(getIntent().getStringExtra("address"));
		textview23info.setText(getIntent().getStringExtra("store services"));
		store_name.setText(getIntent().getStringExtra("store name"));
		textview41upi_id.setText(getIntent().getStringExtra("upi id"));
		t_cadegye.setText(getIntent().getStringExtra("store category"));
		textview31reviews.setText(getIntent().getStringExtra("review"));
		user_key = getIntent().getStringExtra("user key");
		view1 = getIntent().getStringExtra("view1");
		view1 = String.valueOf((long)(Double.parseDouble(view1) + 1));
		STORE_DB.child(user_key).child("view1").setValue(view1);
		imageview5.setColorFilter(0xFF2962FF, PorterDuff.Mode.MULTIPLY);
		imageview12.setColorFilter(0xFF2962FF, PorterDuff.Mode.MULTIPLY);
		imageview13.setColorFilter(0xFF2962FF, PorterDuff.Mode.MULTIPLY);
		imageview14.setColorFilter(0xFF2962FF, PorterDuff.Mode.MULTIPLY);
		imageview17.setColorFilter(0xFF2962FF, PorterDuff.Mode.MULTIPLY);
		imageview15.setColorFilter(0xFF2962FF, PorterDuff.Mode.MULTIPLY);
		imageview18.setColorFilter(0xFF2962FF, PorterDuff.Mode.MULTIPLY);
		_ClickColor(linear7, "#ffffff", "#0d47a1", "#ffffff", "#9e9e9e", 2, 20);
		_ClickColor(linear22, "#ffffff", "#0d47a1", "#ffffff", "#9e9e9e", 2, 20);
		_ClickColor(linear44, "#ffffff", "#0d47a1", "#ffffff", "#9e9e9e", 2, 20);
		_ClickColor(linear32, "#ffffff", "#0d47a1", "#ffffff", "#9e9e9e", 2, 20);
		_ClickColor(linear34, "#ffffff", "#0d47a1", "#ffffff", "#9e9e9e", 2, 20);
		_ClickColor(linear36, "#ffffff", "#0d47a1", "#ffffff", "#9e9e9e", 2, 20);
		_ClickColor(linear19, "#e3f2fd", "#0d47a1", "#9e9e9e", "#9e9e9e", 2, 20);
		_ClickColor(linear54, "#e3f2fd", "#0d47a1", "#9e9e9e", "#9e9e9e", 2, 20);
		_ClickColor(linear55, "#e3f2fd", "#0d47a1", "#9e9e9e", "#9e9e9e", 2, 20);
		_ClickColor(linear49, "#e3f2fd", "#0d47a1", "#9e9e9e", "#9e9e9e", 2, 20);
		_ClickColor(linear50, "#e3f2fd", "#0d47a1", "#9e9e9e", "#9e9e9e", 2, 20);
		_ClickColor(linear53, "#e3f2fd", "#0d47a1", "#9e9e9e", "#9e9e9e", 2, 20);
		_ClickColor(linear51, "#e3f2fd", "#0d47a1", "#9e9e9e", "#9e9e9e", 2, 20);
		_ClickColor(linear52, "#e3f2fd", "#0d47a1", "#9e9e9e", "#9e9e9e", 2, 20);
		_ClickColor(store_name, "#0d47a1", "#0d47a1", "#9e9e9e", "#9e9e9e", 2, 20);
		_customNav("#0d47a1");
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
		network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _network_request_listener);
	}
	public void _card_style (final View _view, final double _shadow, final double _rounds, final String _colour) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_colour));
		gd.setCornerRadius((int)_rounds);
		_view.setBackground(gd);
		_view.setElevation((int)_shadow);
	}
	
	
	public void _bounce (final View _view) {
		oa.setTarget(_view);
		oa.setPropertyName("rotation");
		oa.setFloatValues((float)(90), (float)(0));
		oa.setDuration((int)(1000));
		oa.setInterpolator(new BounceInterpolator());
		oa.start();
	}
	
	
	public void _ClickColor (final View _v, final String _bcf, final String _scf, final String _bcp, final String _scp, final double _s, final double _r) {
		android.graphics.drawable.GradientDrawable style = new android.graphics.drawable.GradientDrawable();
		style.setCornerRadius((float)_r);
		style.setColor(new android.content.res.ColorStateList(new int[][] {{ -android.R.attr.state_pressed} , {android.R.attr.state_pressed}}, new int [] {Color.parseColor(_bcf), Color.parseColor(_bcp)}));
		style.setStroke((int)_s, new android.content.res.ColorStateList(new int [][] {{ -android.R.attr.state_pressed}, {android.R.attr.state_pressed}}, new int [] {Color.parseColor(_scf), Color.parseColor(_scp)}));
		_v.setBackground(style);
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
	
	
	public void _Download (final String _url, final String _path) {
		FileUtil.makeDir(FileUtil.getPackageDataDir(getApplicationContext()));
		
		android.net.ConnectivityManager connMgr = (android.net.ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		android.net.NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			
			
			final String urlDownload = _url;
			
			DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlDownload));
			
			final String fileName = URLUtil.guessFileName(urlDownload, null, null);
			
			request.setDescription("URL - " + urlDownload);
			
			request.setTitle(fileName);
			
			request.allowScanningByMediaScanner();
			
			request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
			
			request.setDestinationInExternalPublicDir(_path, fileName);
			
			final DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
			
			final long downloadId = manager.enqueue(request);
			
			final ProgressDialog prog = new ProgressDialog(this);
			prog.setMax(100);
			prog.setIndeterminate(true);
			prog.setCancelable(false);
			prog.setCanceledOnTouchOutside(false);
			
			prog.setTitle("Please Wait...");
			prog.setMessage("Downloading the " + fileName + ".\n\nProgress - 0%");
			prog.show();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					
					boolean downloading = true;
					
					while (downloading) {
						
						DownloadManager.Query q = new DownloadManager.Query();
						
						q.setFilterById(downloadId);
						
						android.database.Cursor cursor = manager.query(q);
						
						cursor.moveToFirst();
						
						int bytes_downloaded = cursor.getInt(cursor .getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
						
						int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
						
						if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
							
							downloading = false;
							
						}
						
						final int dl_progress = (int) ((bytes_downloaded * 100l) / bytes_total);
						
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								
								prog.setTitle("Please Wait...");
								prog.setMessage("Downloading the " + fileName + ".\n\nProgress - " + dl_progress + "%");
								prog.show();
								
								if (dl_progress == 100) {
									prog.dismiss();
								}
								
							} });
					} } }).start();
			
			
		} else {
			showMessage("No Internet Connection.");
		}
	}
	
	
	public void _customNav (final String _color) {
		//Code From StackOverFlow.com And Converted By TeamWorks DEV
		if (Build.VERSION.SDK_INT >= 21) {
			Window w = this.getWindow();
			w.setNavigationBarColor(Color.parseColor(_color));
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