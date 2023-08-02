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
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.EditText;
import android.widget.Button;
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
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.content.Intent;
import android.content.ClipData;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class ResaleUploadActivity extends  AppCompatActivity  { 
	
	public final int REQ_CD_RSIPICKER = 101;
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private HashMap<String, Object> RSmap = new HashMap<>();
	private String rspath = "";
	private String rsname = "";
	private String user_key = "";
	private String rs2path = "";
	private String rs2name = "";
	
	private TextView textview66;
	private WebView webview1;
	private LinearLayout main_loading_linear;
	private ScrollView vscroll1;
	private ImageView imageview16;
	private ProgressBar progressbar2;
	private TextView textview65;
	private LinearLayout linear35;
	private ImageView imageview15;
	private LinearLayout linear31;
	private LinearLayout linear38;
	private TextView textview4;
	private EditText product;
	private EditText price;
	private LinearLayout linear40;
	private LinearLayout linear41;
	private LinearLayout linear36;
	private TextView textview3;
	private EditText area;
	private EditText city;
	private EditText state;
	private LinearLayout linear37;
	private TextView textview2;
	private LinearLayout linear39;
	private Button submit_button;
	private ProgressBar progressbar1;
	private TextView loading_t;
	private EditText code;
	private EditText contact;
	private EditText edittext1;
	private EditText whatsapp;
	private EditText description;
	
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
	private DatabaseReference RESELLPRODUCT = _firebase.getReference("RESELLPRODUCT");
	private ChildEventListener _RESELLPRODUCT_child_listener;
	private StorageReference RESELLimage = _firebase_storage.getReference("RESELLimage");
	private OnCompleteListener<Uri> _RESELLimage_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _RESELLimage_download_success_listener;
	private OnSuccessListener _RESELLimage_delete_success_listener;
	private OnProgressListener _RESELLimage_upload_progress_listener;
	private OnProgressListener _RESELLimage_download_progress_listener;
	private OnFailureListener _RESELLimage_failure_listener;
	private SharedPreferences rsi;
	private Calendar calendar = Calendar.getInstance();
	private Intent RSIpicker = new Intent(Intent.ACTION_GET_CONTENT);
	private AlertDialog.Builder submit_d;
	private Intent rsp_i = new Intent();
	private TimerTask upload_time;
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.resale_upload);
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
		textview66 = (TextView) findViewById(R.id.textview66);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		main_loading_linear = (LinearLayout) findViewById(R.id.main_loading_linear);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		imageview16 = (ImageView) findViewById(R.id.imageview16);
		progressbar2 = (ProgressBar) findViewById(R.id.progressbar2);
		textview65 = (TextView) findViewById(R.id.textview65);
		linear35 = (LinearLayout) findViewById(R.id.linear35);
		imageview15 = (ImageView) findViewById(R.id.imageview15);
		linear31 = (LinearLayout) findViewById(R.id.linear31);
		linear38 = (LinearLayout) findViewById(R.id.linear38);
		textview4 = (TextView) findViewById(R.id.textview4);
		product = (EditText) findViewById(R.id.product);
		price = (EditText) findViewById(R.id.price);
		linear40 = (LinearLayout) findViewById(R.id.linear40);
		linear41 = (LinearLayout) findViewById(R.id.linear41);
		linear36 = (LinearLayout) findViewById(R.id.linear36);
		textview3 = (TextView) findViewById(R.id.textview3);
		area = (EditText) findViewById(R.id.area);
		city = (EditText) findViewById(R.id.city);
		state = (EditText) findViewById(R.id.state);
		linear37 = (LinearLayout) findViewById(R.id.linear37);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear39 = (LinearLayout) findViewById(R.id.linear39);
		submit_button = (Button) findViewById(R.id.submit_button);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		loading_t = (TextView) findViewById(R.id.loading_t);
		code = (EditText) findViewById(R.id.code);
		contact = (EditText) findViewById(R.id.contact);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		whatsapp = (EditText) findViewById(R.id.whatsapp);
		description = (EditText) findViewById(R.id.description);
		auth = FirebaseAuth.getInstance();
		rsi = getSharedPreferences("rsi", Activity.MODE_PRIVATE);
		RSIpicker.setType("image/*");
		RSIpicker.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		submit_d = new AlertDialog.Builder(this);
		network = new RequestNetwork(this);
		
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
		
		main_loading_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(RSIpicker, REQ_CD_RSIPICKER);
			}
		});
		
		city.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		submit_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				submit_d.setTitle("SUBMIT YOUR PRODUCT DETAILS");
				submit_d.setMessage("Have you checked the product information well? If not, check again and submit it.");
				submit_d.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if (product.getText().toString().length() > 30) {
							SketchwareUtil.showMessage(getApplicationContext(), "The maximum number of letters in owner name is 30");
						}
						else {
							if (rsi.getString("rsi", "").equals("")) {
								SketchwareUtil.showMessage(getApplicationContext(), "Add your product photo");
							}
							else {
								if (product.getText().toString().equals("")) {
									SketchwareUtil.showMessage(getApplicationContext(), "Enter your product name");
								}
								else {
									if (price.getText().toString().equals("")) {
										SketchwareUtil.showMessage(getApplicationContext(), "Enter your product price");
									}
									else {
										if (contact.getText().toString().equals("")) {
											SketchwareUtil.showMessage(getApplicationContext(), "Enter your contact number");
										}
										else {
											if (whatsapp.getText().toString().equals("")) {
												SketchwareUtil.showMessage(getApplicationContext(), "Enter your whatsapp number");
											}
											else {
												if (area.getText().toString().equals("")) {
													SketchwareUtil.showMessage(getApplicationContext(), "Enter your area");
												}
												else {
													if (city.getText().toString().equals("")) {
														SketchwareUtil.showMessage(getApplicationContext(), "Enter your city");
													}
													else {
														if (state.getText().toString().equals("")) {
															SketchwareUtil.showMessage(getApplicationContext(), "Enter your state");
														}
														else {
															if (description.getText().toString().equals("")) {
																SketchwareUtil.showMessage(getApplicationContext(), "Enter your Description");
															}
															else {
																user_key = RESELLPRODUCT.push().getKey();
																calendar = Calendar.getInstance();
																RSmap = new HashMap<>();
																RSmap.put("user key", user_key);
																RSmap.put("extra", "key");
																RSmap.put("views", "0");
																RSmap.put("product name", product.getText().toString());
																RSmap.put("product price", price.getText().toString());
																RSmap.put("country code", code.getText().toString());
																RSmap.put("contact number", contact.getText().toString());
																RSmap.put("whatsapp number", whatsapp.getText().toString());
																RSmap.put("area", area.getText().toString());
																RSmap.put("city", city.getText().toString());
																RSmap.put("state", state.getText().toString());
																RSmap.put("description", description.getText().toString());
																RSmap.put("product photo", rsi.getString("rsi", ""));
																RSmap.put("day", new SimpleDateFormat("dd").format(calendar.getTime()));
																RSmap.put("month", new SimpleDateFormat("MM").format(calendar.getTime()));
																RSmap.put("year", new SimpleDateFormat("yyyy").format(calendar.getTime()));
																RESELLPRODUCT.child(user_key).updateChildren(RSmap);
																RSmap.clear();
																upload_time = new TimerTask() {
																	@Override
																	public void run() {
																		runOnUiThread(new Runnable() {
																			@Override
																			public void run() {
																				rsp_i.setClass(getApplicationContext(), ProductActivity.class);
																				startActivity(rsp_i);
																				finish();
																			}
																		});
																	}
																};
																_timer.schedule(upload_time, (int)(4000));
																main_loading_linear.setVisibility(View.VISIBLE);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				});
				submit_d.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SketchwareUtil.showMessage(getApplicationContext(), "Please check all details...");
					}
				});
				submit_d.create().show();
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
		
		_RESELLimage_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				linear31.setVisibility(View.VISIBLE);
				loading_t.setText("Uploading...".concat(String.valueOf((long)(_progressValue)).concat(" %")));
			}
		};
		
		_RESELLimage_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_RESELLimage_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				rsi.edit().putString("rsi", _downloadUrl).commit();
				progressbar1.setVisibility(View.GONE);
				loading_t.setText("Product photo uplode successful");
				loading_t.setTextColor(0xFF64DD17);
			}
		};
		
		_RESELLimage_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_RESELLimage_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_RESELLimage_failure_listener = new OnFailureListener() {
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
				network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontactsnew.firebaseio.com/", _tag, _network_request_listener);
				textview66.setText("No internet connection");
				textview66.setVisibility(View.GONE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontactsnew.firebaseio.com/", _tag, _network_request_listener);
				textview66.setVisibility(View.GONE);
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
		textview66.setVisibility(View.GONE);
		main_loading_linear.setVisibility(View.GONE);
		_ClickColor(product, "#e3f2fd", "#0d47a1", "#e3f2fd", "#9e9e9e", 2, 16);
		_ClickColor(price, "#e3f2fd", "#0d47a1", "#e3f2fd", "#9e9e9e", 2, 16);
		_ClickColor(code, "#e3f2fd", "#0d47a1", "#e3f2fd", "#9e9e9e", 2, 16);
		_ClickColor(edittext1, "#e3f2fd", "#0d47a1", "#e3f2fd", "#9e9e9e", 2, 16);
		_ClickColor(contact, "#e3f2fd", "#0d47a1", "#e3f2fd", "#9e9e9e", 2, 16);
		_ClickColor(whatsapp, "#e3f2fd", "#0d47a1", "#e3f2fd", "#9e9e9e", 2, 16);
		_ClickColor(area, "#e3f2fd", "#0d47a1", "#e3f2fd", "#9e9e9e", 2, 16);
		_ClickColor(city, "#e3f2fd", "#0d47a1", "#e3f2fd", "#9e9e9e", 2, 16);
		_ClickColor(state, "#e3f2fd", "#0d47a1", "#e3f2fd", "#9e9e9e", 2, 16);
		_ClickColor(description, "#e3f2fd", "#0d47a1", "#e3f2fd", "#9e9e9e", 2, 16);
		_ClickColor(imageview15, "#e3f2fd", "#0d47a1", "#e3f2fd", "#9e9e9e", 2, 16);
		_ClickColor(submit_button, "#0d47a1", "#ffffff", "#9e9e9e", "#ffffff", 4, 16);
		_removeScollBar(linear35);
		_customNav("#0d47a1");
		network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontactsnew.firebaseio.com/", "KOTRAContacts App", _network_request_listener);
		webview1.loadUrl("data:text/html,<html><body> <marquee behavior=\"scroll\" direction=\"left\"> <h2<alignt style=\"color:red\">".concat("नोट :- रीसेल प्रोडक्ट में की गई पोस्ट 30 दिन उपरांत सिस्टम द्वारा डिलीट कर दी जाएगी यदि आप का प्रोडक्ट सेल ना हुआ हो तो 30 दिन बाद दोबारा पोस्ट करें ।".concat("</marquee></html></body> ")));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_RSIPICKER:
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
				rspath = _filePath.get((int)(0));
				rsname = Uri.parse(_filePath.get((int)(0))).getLastPathSegment();
				imageview15.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(rspath, 1024, 1024));
				RESELLimage.child(rsname).putFile(Uri.fromFile(new File(rspath))).addOnFailureListener(_RESELLimage_failure_listener).addOnProgressListener(_RESELLimage_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return RESELLimage.child(rsname).getDownloadUrl();
					}}).addOnCompleteListener(_RESELLimage_upload_success_listener);
			}
			else {
				_Toast("ffffff", "0d47a1", "Uploading cancel");
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
	
	
	public void _customNav (final String _color) {
		//Code From StackOverFlow.com And Converted By TeamWorks DEV
		if (Build.VERSION.SDK_INT >= 21) {
			Window w = this.getWindow();
			w.setNavigationBarColor(Color.parseColor(_color));
		}
	}
	
	
	public void _removeScollBar (final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
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