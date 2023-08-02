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
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageView;
import java.util.Calendar;
import java.text.SimpleDateFormat;
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
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class ReviewActivity extends  AppCompatActivity  { 
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String user_key = "";
	private HashMap<String, Object> review1 = new HashMap<>();
	private String post_key = "";
	private double review_n = 0;
	private String nickname = "";
	
	private ArrayList<HashMap<String, Object>> usercomments = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> store_listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> user_listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear7;
	private ListView listview1;
	private LinearLayout linear4;
	private LinearLayout linear6;
	private TextView textview2;
	private TextView textview3;
	private TextView textview1;
	private EditText type_review;
	private ImageView imageview2;
	
	private Calendar calendar = Calendar.getInstance();
	private DatabaseReference review_db = _firebase.getReference("review_db");
	private ChildEventListener _review_db_child_listener;
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
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private DatabaseReference user_id = _firebase.getReference("user_id");
	private ChildEventListener _user_id_child_listener;
	private Intent profile_i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.review);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		listview1 = (ListView) findViewById(R.id.listview1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview1 = (TextView) findViewById(R.id.textview1);
		type_review = (EditText) findViewById(R.id.type_review);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		auth = FirebaseAuth.getInstance();
		network = new RequestNetwork(this);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (type_review.getText().toString().equals("")) {
					_Toast("ffffff", "0d47a1", "type your review");
				}
				else {
					user_key = review_db.push().getKey();
					calendar = Calendar.getInstance();
					review1 = new HashMap<>();
					review1.put("user key", FirebaseAuth.getInstance().getCurrentUser().getUid());
					review1.put("post_key", post_key);
					review1.put("review", type_review.getText().toString());
					review1.put("stars", textview1.getText().toString());
					review1.put("review time", new SimpleDateFormat("dd/MM/yyyy  hh:mm a").format(calendar.getTime()));
					review1.put("customer", nickname);
					review_db.push().updateChildren(review1);
					review1.clear();
					type_review.setText("");
				}
			}
		});
		
		_review_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (post_key.equals(_childValue.get("post_key").toString())) {
					usercomments.add(_childValue);
					listview1.setAdapter(new Listview1Adapter(usercomments));
					listview1.smoothScrollToPosition((int)(usercomments.size()));
				}
				else {
					
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				review_db.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						usercomments = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								usercomments.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(usercomments));
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
				review_db.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						usercomments = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								usercomments.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(usercomments));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
				network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", _tag, _network_request_listener);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", _tag, _network_request_listener);
			}
		};
		
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
									nickname = _childValue.get("nickname").toString();
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
		post_key = getIntent().getStringExtra("user key");
		imageview2.setColorFilter(0xFF64DD17, PorterDuff.Mode.MULTIPLY);
		rb = new RatingBar(this);
		rb.setNumStars(5);
		rb.setStepSize(0.5f);
		rb.setRating(5.0f);
		linear4.addView(rb);
		
		rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
			@Override
			public void
			onRatingChanged(RatingBar rating, float r, boolean user){
				
				textview1.setText(String.valueOf(rb.getRating()));
			}
		});
		
	}
	RatingBar rb;
	
	private void nothing(){
		network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _network_request_listener);
		_ClickColor(type_review, "#ffffff", "#ffffff", "#ffffff", "#ffffff", 16, 40);
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
	
	
	public void _view3D (final View _v, final double _n) {
		_v.setElevation((float)_n);
	}
	
	
	public void _radius (final String _color, final double _numb, final View _view) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
		_view.setElevation((int)_numb);
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
	
	
	public void _customNav (final String _color) {
		//Code From StackOverFlow.com And Converted By TeamWorks DEV
		if (Build.VERSION.SDK_INT >= 21) {
			Window w = this.getWindow();
			w.setNavigationBarColor(Color.parseColor(_color));
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
				_view = _inflater.inflate(R.layout.custom_review, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = (LinearLayout) _view.findViewById(R.id.linear4);
			final TextView textview3 = (TextView) _view.findViewById(R.id.textview3);
			final TextView customer = (TextView) _view.findViewById(R.id.customer);
			final TextView textview4 = (TextView) _view.findViewById(R.id.textview4);
			final TextView review = (TextView) _view.findViewById(R.id.review);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final TextView star_number = (TextView) _view.findViewById(R.id.star_number);
			final TextView review_time = (TextView) _view.findViewById(R.id.review_time);
			
			review.setText(usercomments.get((int)(usercomments.size() - 1) - _position).get("review").toString());
			star_number.setText(usercomments.get((int)(usercomments.size() - 1) - _position).get("stars").toString());
			review_time.setText(usercomments.get((int)(usercomments.size() - 1) - _position).get("review time").toString());
			customer.setText(usercomments.get((int)(usercomments.size() - 1) - _position).get("customer").toString());
			_card_style(linear1, 16, 50, "#ffffff");
			
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