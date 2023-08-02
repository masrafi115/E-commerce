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
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import java.util.HashMap;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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


public class ViewProductActivity extends  AppCompatActivity  { 
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String views = "";
	private String user_key = "";
	private String shear = "";
	private String urlDownload = "";
	private String time = "";
	
	private TextView textview67;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private ImageView imageview1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear7;
	private LinearLayout linear9;
	private TextView t_userkey;
	private TextView t_extra;
	private LinearLayout linear6;
	private LinearLayout linear29;
	private TextView textview2;
	private ImageView imageview2;
	private TextView textview11;
	private TextView textview1;
	private LinearLayout linear12;
	private TextView textview12;
	private TextView textview13;
	private TextView textview3;
	private ImageView imageview8;
	private TextView tview;
	private TextView textview19;
	private LinearLayout linear11;
	private LinearLayout linear5;
	private ImageView imageview7;
	private TextView textview14;
	private TextView t_call;
	private TextView textview17;
	private TextView t_wa;
	private LinearLayout linear8;
	private TextView textview6;
	private ImageView imageview5;
	private TextView textview15;
	private LinearLayout linear10;
	private TextView textview7;
	private ImageView imageview6;
	private TextView textview16;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private LinearLayout linear16;
	private LinearLayout linear19;
	private LinearLayout linear15;
	private LinearLayout linear20;
	private LinearLayout linear13;
	private ImageView imageview9;
	private TextView textview20;
	private ImageView imageview10;
	private TextView textview21;
	private ImageView imageview11;
	private TextView textview22;
	private LinearLayout linear30;
	private LinearLayout linear21;
	private LinearLayout linear31;
	private LinearLayout linear27;
	private LinearLayout linear32;
	private ImageView imageview12;
	private TextView textview23;
	private ImageView imageview15;
	private TextView textview66;
	
	private DatabaseReference RESELLPRODUCT = _firebase.getReference("RESELLPRODUCT");
	private ChildEventListener _RESELLPRODUCT_child_listener;
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
	private Intent call_i = new Intent();
	private Intent wa_i = new Intent();
	private Intent sms_i = new Intent();
	private RequestNetwork internet;
	private RequestNetwork.RequestListener _internet_request_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.view_product);
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
		textview67 = (TextView) findViewById(R.id.textview67);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		t_userkey = (TextView) findViewById(R.id.t_userkey);
		t_extra = (TextView) findViewById(R.id.t_extra);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear29 = (LinearLayout) findViewById(R.id.linear29);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview13 = (TextView) findViewById(R.id.textview13);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		tview = (TextView) findViewById(R.id.tview);
		textview19 = (TextView) findViewById(R.id.textview19);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview14 = (TextView) findViewById(R.id.textview14);
		t_call = (TextView) findViewById(R.id.t_call);
		textview17 = (TextView) findViewById(R.id.textview17);
		t_wa = (TextView) findViewById(R.id.t_wa);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		textview6 = (TextView) findViewById(R.id.textview6);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview15 = (TextView) findViewById(R.id.textview15);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		textview7 = (TextView) findViewById(R.id.textview7);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		textview16 = (TextView) findViewById(R.id.textview16);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		textview20 = (TextView) findViewById(R.id.textview20);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		textview21 = (TextView) findViewById(R.id.textview21);
		imageview11 = (ImageView) findViewById(R.id.imageview11);
		textview22 = (TextView) findViewById(R.id.textview22);
		linear30 = (LinearLayout) findViewById(R.id.linear30);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		linear31 = (LinearLayout) findViewById(R.id.linear31);
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		linear32 = (LinearLayout) findViewById(R.id.linear32);
		imageview12 = (ImageView) findViewById(R.id.imageview12);
		textview23 = (TextView) findViewById(R.id.textview23);
		imageview15 = (ImageView) findViewById(R.id.imageview15);
		textview66 = (TextView) findViewById(R.id.textview66);
		auth = FirebaseAuth.getInstance();
		internet = new RequestNetwork(this);
		
		linear18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				call_i.setAction(Intent.ACTION_VIEW);
				call_i.setData(Uri.parse("tel:".concat(t_call.getText().toString())));
				call_i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(call_i);
			}
		});
		
		linear19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sms_i.setAction(Intent.ACTION_VIEW);
				sms_i.setData(Uri.parse("sms:".concat(t_call.getText().toString())));
				sms_i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(sms_i);
			}
		});
		
		linear20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				wa_i.setAction(Intent.ACTION_VIEW);
				wa_i.setData(Uri.parse("https://api.whatsapp.com/send?phone=".concat(t_wa.getText().toString())));
				wa_i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(wa_i);
			}
		});
		
		linear21.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shear = "KOTRA Contact's App\n\nReference :- ".concat(FirebaseAuth.getInstance().getCurrentUser().getEmail()).concat("\n".concat(textview2.getText().toString().concat("\n₹".concat(textview3.getText().toString().concat("\n".concat(t_call.getText().toString().concat("\n".concat(textview6.getText().toString().concat("\n".concat(textview7.getText().toString().concat("\n\n📲 For more information download the app...> \nhttp://www.kotracontacts.in/2020/03/blog-post.html?m=1")))))))))));
				Intent i = new Intent(android.content.Intent.ACTION_SEND);i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT,shear); startActivity(Intent.createChooser(i,"Click to Share"));
			}
		});
		
		linear27.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_download(getIntent().getStringExtra("product photo"), textview2.getText().toString().concat(".png"));
			}
		});
		
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
		
		_internet_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				textview67.setVisibility(View.GONE);
				internet.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _internet_request_listener);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				internet.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _internet_request_listener);
				textview67.setVisibility(View.VISIBLE);
				textview67.setText("No internet connection...");
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
		internet.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _internet_request_listener);
		textview67.setVisibility(View.GONE);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("product photo"))).into(imageview1);
		textview1.setText(getIntent().getStringExtra("date"));
		textview2.setText(getIntent().getStringExtra("product name"));
		textview3.setText(getIntent().getStringExtra("product price"));
		t_call.setText(getIntent().getStringExtra("contact number"));
		t_wa.setText(getIntent().getStringExtra("whatsapp number"));
		textview6.setText(getIntent().getStringExtra("address"));
		textview7.setText(getIntent().getStringExtra("description"));
		t_userkey.setText(getIntent().getStringExtra("user key"));
		t_extra.setText(getIntent().getStringExtra("extra"));
		tview.setText(getIntent().getStringExtra("views"));
		user_key = getIntent().getStringExtra("user key");
		views = getIntent().getStringExtra("views");
		views = String.valueOf((long)(Double.parseDouble(views) + 1));
		RESELLPRODUCT.child(user_key).child("views").setValue(views);
		_ClickColor(linear18, "#e3f2fd", "#9e9e9e", "#9e9e9e", "#0d47a1", 4, 25);
		_ClickColor(linear19, "#e3f2fd", "#9e9e9e", "#9e9e9e", "#0d47a1", 4, 25);
		_ClickColor(linear20, "#e3f2fd", "#9e9e9e", "#9e9e9e", "#0d47a1", 4, 25);
		_ClickColor(linear21, "#e3f2fd", "#9e9e9e", "#9e9e9e", "#0d47a1", 4, 25);
		_ClickColor(linear27, "#e3f2fd", "#9e9e9e", "#9e9e9e", "#0d47a1", 4, 25);
		_ClickColor(linear4, "#ffffff", "#9e9e9e", "#ffffff", "#0d47a1", 4, 25);
		_ClickColor(linear7, "#ffffff", "#9e9e9e", "#ffffff", "#0d47a1", 4, 25);
		_ClickColor(linear9, "#ffffff", "#9e9e9e", "#ffffff", "#0d47a1", 4, 25);
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
		internet.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _internet_request_listener);
	}
	public void _setTransactionName (final View _view, final String _transitionName) {
		_view.setTransitionName(_transitionName);
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
	
	
	public void _ClickColor (final View _v, final String _bcf, final String _scf, final String _bcp, final String _scp, final double _s, final double _r) {
		android.graphics.drawable.GradientDrawable style = new android.graphics.drawable.GradientDrawable();
		style.setCornerRadius((float)_r);
		style.setColor(new android.content.res.ColorStateList(new int[][] {{ -android.R.attr.state_pressed} , {android.R.attr.state_pressed}}, new int [] {Color.parseColor(_bcf), Color.parseColor(_bcp)}));
		style.setStroke((int)_s, new android.content.res.ColorStateList(new int [][] {{ -android.R.attr.state_pressed}, {android.R.attr.state_pressed}}, new int [] {Color.parseColor(_scf), Color.parseColor(_scp)}));
		_v.setBackground(style);
	}
	
	
	public void _ShareImage (final View _view, final String _screen) {
		Bitmap image = Bitmap.createBitmap(_view.getWidth(), _view.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(image);
		android.graphics.drawable.Drawable bgDrawable = _view.getBackground();
		if (bgDrawable!=null) {
			bgDrawable.draw(canvas);
		} else{
			canvas.drawColor(Color.WHITE);
		}
		_view.draw(canvas);
		
		java.io.File pictureFile = new java.io.File(getExternalCacheDir() + "/image.png");
		if (pictureFile == null) {
			Log.d("_screen", "Erro,Cheque As Permissões: ");
			return;
		}
		try {
			java.io.FileOutputStream fos = new java.io.FileOutputStream(pictureFile); 
			image.compress(Bitmap.CompressFormat.PNG, 90, fos);
			fos.close();
		} catch (java.io.FileNotFoundException e) {
			Log.d("_screen", "Sem Aquivos: " + e.getMessage());
		} catch (java.io.IOException e) {
			Log.d("_screen", "Erro Ao Obter Arquivo: " + e.getMessage());
		}
		Intent iten = new Intent(android.content.Intent.ACTION_SEND);
		iten.setType("image/*");
		iten.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new java.io.File(getExternalCacheDir() + "/image.png")));
		startActivity(Intent.createChooser(iten, "share details"));
	}
	
	
	public void _imageDownload (final ImageView _urlDownload, final String _png) {
		time = _png;
		urlDownload = "";
		DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlDownload));
		request.setDescription("KOTRA Contacts");
		request.setTitle("Downloading Business Card");
		request.allowScanningByMediaScanner();
		request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
		request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, (time));
		final DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
		final long downloadId = manager.enqueue(request);
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				boolean downloading = true;
				while (downloading) {
					DownloadManager.Query q = new DownloadManager.Query();
					q.setFilterById(downloadId);
					android.database.Cursor cursor = manager.query(q);
					cursor.moveToFirst();
					int bytes_downloaded = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
					
					int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
					if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
						downloading = false;
					}
					final int dl_progress = (int) ((bytes_downloaded * 100l) / bytes_total);
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
						}
					});
					//Log.d(Constants.MAIN_VIEW_ACTIVITY, statusMessage(cursor));
					cursor.close();
				}
			}
		}).start();
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
			
			request.setDestinationInExternalPublicDir(_path, fileName);
			
			final DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
			
			final long downloadId = manager.enqueue(request);
			
			final ProgressDialog prog = new ProgressDialog(this);
			prog.setMax(100);
			prog.setIndeterminate(true);
			prog.setCancelable(false);
			prog.setCanceledOnTouchOutside(false);
			prog.setTitle("Downloading...");
			
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
								
								prog.setTitle("Connected to server");
								prog.setMessage("Downloading ATPH files\n\nProgress - " + dl_progress + "%");
								prog.show();
								showMessage("Downloaded");
								if (dl_progress == 100) {
									prog.dismiss();
								}
								
							} });
					} } }).start();
			
			
		} else {
			showMessage("No Internet Connection.");
		}
	}
	
	
	public void _download (final String _url, final String _path) {
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