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
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
import java.io.File;
import android.content.ClipData;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.widget.AdapterView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class PementActivity extends  AppCompatActivity  { 
	
	public final int REQ_CD_SCREENSHOT_PICKER = 101;
	public final int REQ_CD_PROFILE_PHOTO_PICKER = 102;
	public final int REQ_CD_STORE_PHOTO_PICKER = 103;
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private String apath = "";
	private String aname = "";
	private String bpath = "";
	private String bname = "";
	private String cpath = "";
	private String cname = "";
	private String user_key = "";
	private HashMap<String, Object> store_map = new HashMap<>();
	private String DBoffer = "";
	private String DBamount = "";
	private HashMap<String, Object> offermap = new HashMap<>();
	
	private ArrayList<String> categorylist = new ArrayList<>();
	
	private TextView textview7;
	private LinearLayout linear1;
	private LinearLayout linear27;
	private LinearLayout linear36;
	private LinearLayout linear19;
	private TextView textview1;
	private ImageView imageview1;
	private ScrollView vscroll1;
	private LinearLayout second_linear;
	private LinearLayout linear29;
	private LinearLayout linear30;
	private ImageView imageview2;
	private TextView textview2;
	private TextView textview3;
	private LinearLayout linear33;
	private Button button1;
	private TextView textview5;
	private EditText edittext1;
	private LinearLayout main_loading_linear;
	private ScrollView vscroll3;
	private ImageView imageview14;
	private ProgressBar progressbar6;
	private TextView textview65;
	private TextView textview66;
	private LinearLayout linear37;
	private LinearLayout linear44;
	private LinearLayout linear2;
	private LinearLayout linear10;
	private LinearLayout linear40;
	private ImageView spimage;
	private LinearLayout linear41;
	private EditText store_name_t;
	private LinearLayout linear3;
	private LinearLayout linear24;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear25;
	private LinearLayout linear26;
	private LinearLayout linear42;
	private LinearLayout linear43;
	private LinearLayout linear49;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear62;
	private ImageView imageview13;
	private LinearLayout linear31;
	private ImageView imageview20;
	private EditText reference_edittext;
	private ProgressBar progressbar4;
	private TextView textview9;
	private ImageView ppimage;
	private LinearLayout linear11;
	private LinearLayout linear;
	private LinearLayout linear17;
	private EditText owner_name_t;
	private EditText email_address_t;
	private ProgressBar progressbar1;
	private TextView pp_loading;
	private ProgressBar progressbar2;
	private TextView sp_loading;
	private ImageView imageview3;
	private EditText category_t;
	private Spinner spinner2;
	private ImageView imageview8;
	private EditText country_code_t;
	private ImageView imageview4;
	private EditText mobile_number_t;
	private ImageView imageview7;
	private EditText whatsapp_number_t;
	private ImageView imageview5;
	private EditText store_number_t;
	private ImageView imageview9;
	private EditText area_t;
	private ImageView imageview10;
	private EditText city_t;
	private ImageView imageview11;
	private EditText state_t;
	private ImageView imageview12;
	private EditText country_t;
	private ImageView imageview16;
	private EditText upi_edittext3;
	private ImageView imageview6;
	private EditText store_services_t;
	private Button button4;
	private LinearLayout button_linear;
	private Button button5;
	private Button button6;
	
	private AlertDialog.Builder D1;
	private Intent intent = new Intent();
	private Intent email_i = new Intent();
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
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
	private DatabaseReference NEW_STORE_DATA_DB = _firebase.getReference("NEW_STORE_DATA_DB");
	private ChildEventListener _NEW_STORE_DATA_DB_child_listener;
	private StorageReference NEW_STORE_STORAGE = _firebase_storage.getReference("NEW_STORE_STORAGE");
	private OnCompleteListener<Uri> _NEW_STORE_STORAGE_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _NEW_STORE_STORAGE_download_success_listener;
	private OnSuccessListener _NEW_STORE_STORAGE_delete_success_listener;
	private OnProgressListener _NEW_STORE_STORAGE_upload_progress_listener;
	private OnProgressListener _NEW_STORE_STORAGE_download_progress_listener;
	private OnFailureListener _NEW_STORE_STORAGE_failure_listener;
	private Intent screenshot_picker = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent profile_photo_picker = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent store_photo_picker = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference NEW_PROFILE_STORAGE = _firebase_storage.getReference("NEW_PROFILE_STORAGE");
	private OnCompleteListener<Uri> _NEW_PROFILE_STORAGE_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _NEW_PROFILE_STORAGE_download_success_listener;
	private OnSuccessListener _NEW_PROFILE_STORAGE_delete_success_listener;
	private OnProgressListener _NEW_PROFILE_STORAGE_upload_progress_listener;
	private OnProgressListener _NEW_PROFILE_STORAGE_download_progress_listener;
	private OnFailureListener _NEW_PROFILE_STORAGE_failure_listener;
	private StorageReference PAY_DATA_STORAGE = _firebase_storage.getReference("PAY_DATA_STORAGE");
	private OnCompleteListener<Uri> _PAY_DATA_STORAGE_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _PAY_DATA_STORAGE_download_success_listener;
	private OnSuccessListener _PAY_DATA_STORAGE_delete_success_listener;
	private OnProgressListener _PAY_DATA_STORAGE_upload_progress_listener;
	private OnProgressListener _PAY_DATA_STORAGE_download_progress_listener;
	private OnFailureListener _PAY_DATA_STORAGE_failure_listener;
	private SharedPreferences store_photo;
	private SharedPreferences profile_photo;
	private SharedPreferences payment;
	private AlertDialog.Builder submit_d;
	private Calendar calendar = Calendar.getInstance();
	private TimerTask t1;
	private TimerTask t2;
	private DatabaseReference STORE_OFFER = _firebase.getReference("STORE_OFFER");
	private ChildEventListener _STORE_OFFER_child_listener;
	private SharedPreferences offersp;
	private AlertDialog.Builder offer_d;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.pement);
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
		
		textview7 = (TextView) findViewById(R.id.textview7);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		linear36 = (LinearLayout) findViewById(R.id.linear36);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		second_linear = (LinearLayout) findViewById(R.id.second_linear);
		linear29 = (LinearLayout) findViewById(R.id.linear29);
		linear30 = (LinearLayout) findViewById(R.id.linear30);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		linear33 = (LinearLayout) findViewById(R.id.linear33);
		button1 = (Button) findViewById(R.id.button1);
		textview5 = (TextView) findViewById(R.id.textview5);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		main_loading_linear = (LinearLayout) findViewById(R.id.main_loading_linear);
		vscroll3 = (ScrollView) findViewById(R.id.vscroll3);
		imageview14 = (ImageView) findViewById(R.id.imageview14);
		progressbar6 = (ProgressBar) findViewById(R.id.progressbar6);
		textview65 = (TextView) findViewById(R.id.textview65);
		textview66 = (TextView) findViewById(R.id.textview66);
		linear37 = (LinearLayout) findViewById(R.id.linear37);
		linear44 = (LinearLayout) findViewById(R.id.linear44);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear40 = (LinearLayout) findViewById(R.id.linear40);
		spimage = (ImageView) findViewById(R.id.spimage);
		linear41 = (LinearLayout) findViewById(R.id.linear41);
		store_name_t = (EditText) findViewById(R.id.store_name_t);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear24 = (LinearLayout) findViewById(R.id.linear24);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear25 = (LinearLayout) findViewById(R.id.linear25);
		linear26 = (LinearLayout) findViewById(R.id.linear26);
		linear42 = (LinearLayout) findViewById(R.id.linear42);
		linear43 = (LinearLayout) findViewById(R.id.linear43);
		linear49 = (LinearLayout) findViewById(R.id.linear49);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear62 = (LinearLayout) findViewById(R.id.linear62);
		imageview13 = (ImageView) findViewById(R.id.imageview13);
		linear31 = (LinearLayout) findViewById(R.id.linear31);
		imageview20 = (ImageView) findViewById(R.id.imageview20);
		reference_edittext = (EditText) findViewById(R.id.reference_edittext);
		progressbar4 = (ProgressBar) findViewById(R.id.progressbar4);
		textview9 = (TextView) findViewById(R.id.textview9);
		ppimage = (ImageView) findViewById(R.id.ppimage);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear = (LinearLayout) findViewById(R.id.linear);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		owner_name_t = (EditText) findViewById(R.id.owner_name_t);
		email_address_t = (EditText) findViewById(R.id.email_address_t);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		pp_loading = (TextView) findViewById(R.id.pp_loading);
		progressbar2 = (ProgressBar) findViewById(R.id.progressbar2);
		sp_loading = (TextView) findViewById(R.id.sp_loading);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		category_t = (EditText) findViewById(R.id.category_t);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		country_code_t = (EditText) findViewById(R.id.country_code_t);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		mobile_number_t = (EditText) findViewById(R.id.mobile_number_t);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		whatsapp_number_t = (EditText) findViewById(R.id.whatsapp_number_t);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		store_number_t = (EditText) findViewById(R.id.store_number_t);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		area_t = (EditText) findViewById(R.id.area_t);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		city_t = (EditText) findViewById(R.id.city_t);
		imageview11 = (ImageView) findViewById(R.id.imageview11);
		state_t = (EditText) findViewById(R.id.state_t);
		imageview12 = (ImageView) findViewById(R.id.imageview12);
		country_t = (EditText) findViewById(R.id.country_t);
		imageview16 = (ImageView) findViewById(R.id.imageview16);
		upi_edittext3 = (EditText) findViewById(R.id.upi_edittext3);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		store_services_t = (EditText) findViewById(R.id.store_services_t);
		button4 = (Button) findViewById(R.id.button4);
		button_linear = (LinearLayout) findViewById(R.id.button_linear);
		button5 = (Button) findViewById(R.id.button5);
		button6 = (Button) findViewById(R.id.button6);
		D1 = new AlertDialog.Builder(this);
		network = new RequestNetwork(this);
		auth = FirebaseAuth.getInstance();
		screenshot_picker.setType("image/*");
		screenshot_picker.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		profile_photo_picker.setType("image/*");
		profile_photo_picker.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		store_photo_picker.setType("image/*");
		store_photo_picker.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		store_photo = getSharedPreferences("store_photo", Activity.MODE_PRIVATE);
		profile_photo = getSharedPreferences("profile_photo", Activity.MODE_PRIVATE);
		payment = getSharedPreferences("payment", Activity.MODE_PRIVATE);
		submit_d = new AlertDialog.Builder(this);
		offersp = getSharedPreferences("offersp", Activity.MODE_PRIVATE);
		offer_d = new AlertDialog.Builder(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				D1.setTitle("स्टोर बनाने के लिए जानकारी साझा करें !");
				D1.setMessage("(1) जमा की गई राशि का स्क्रीनशॉट\n(2) स्वयं का फोटो\n(3) स्टोर का फोटो\n(4) स्वयं का नाम एवं ईमेल\n(5) स्टोर का नाम\n(6) व्यवसाय का नाम\n(7) मोबाइल नंबर एवं व्हाट्सएप नंबर\n(8) पूर्ण पता\n(9) स्टोर द्वारा दी जाने वाली सर्विसेस ।\n\nनोट :- यह सभी जानकारी नीचे दिए गए व्हाट्सएप एवं ई-मेल द्वारा भेजें जानकारी साझा करने के 1 दिन के अंदर आपकी दुकान KOTRA Contacts App पर आ जाएगी ।");
				D1.setPositiveButton("दुकान खोलने के लिए क्लिक करें", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						vscroll1.setVisibility(View.GONE);
						second_linear.setVisibility(View.VISIBLE);
						button5.setTextColor(0xFFFFFFFF);
						button6.setTextColor(0xFF76FF03);
					}
				});
				D1.setNegativeButton("अगली बार", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						vscroll1.setVisibility(View.VISIBLE);
						second_linear.setVisibility(View.GONE);
						button6.setTextColor(0xFFFFFFFF);
						button5.setTextColor(0xFF76FF03);
					}
				});
				D1.create().show();
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("upi://pay?pa=".concat("9229995901.kotracontacts@upi".concat("&pn=".concat("KOTRAContacts App".concat("&tn=".concat("12 months rent of store in kotra contact App".concat("&am=".concat(edittext1.getText().toString().concat("&cu=".concat("INDIA")))))))))));
				Intent chooser = Intent.createChooser(intent, "use any upi");
				 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
				 { startActivityForResult(chooser, 1, null); }
			}
		});
		
		main_loading_linear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		spimage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(store_photo_picker, REQ_CD_STORE_PHOTO_PICKER);
			}
		});
		
		imageview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(screenshot_picker, REQ_CD_SCREENSHOT_PICKER);
			}
		});
		
		ppimage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(profile_photo_picker, REQ_CD_PROFILE_PHOTO_PICKER);
			}
		});
		
		spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					
				}
				if (_position == 1) {
					category_t.setText("Groceries / Kirana Store");
				}
				if (_position == 2) {
					category_t.setText("Milk parlour / Dairy");
				}
				if (_position == 3) {
					category_t.setText("Vegetable and fruits store");
				}
				if (_position == 4) {
					category_t.setText("Restaurant and food centre");
				}
				if (_position == 5) {
					category_t.setText("Mobile and DTH store");
				}
				if (_position == 6) {
					category_t.setText("Laundry");
				}
				if (_position == 7) {
					category_t.setText("Electrician");
				}
				if (_position == 8) {
					category_t.setText("Passenger vehicle");
				}
				if (_position == 9) {
					category_t.setText("Salon and parlours");
				}
				if (_position == 10) {
					category_t.setText("vehicle private driver");
				}
				if (_position == 11) {
					category_t.setText("Doctor and hospital");
				}
				if (_position == 12) {
					category_t.setText("Vehicle mechanic");
				}
				if (_position == 13) {
					category_t.setText("Home appliances mechanic");
				}
				if (_position == 14) {
					category_t.setText("Hardware store");
				}
				if (_position == 15) {
					category_t.setText("Plumber worker");
				}
				if (_position == 16) {
					category_t.setText("Event organiser");
				}
				if (_position == 17) {
					category_t.setText("Events and party worker");
				}
				if (_position == 18) {
					category_t.setText("Paint store");
				}
				if (_position == 19) {
					category_t.setText("Painter worker");
				}
				if (_position == 20) {
					category_t.setText("Advocate");
				}
				if (_position == 21) {
					category_t.setText("School project and stationery");
				}
				if (_position == 22) {
					category_t.setText("Building material store");
				}
				if (_position == 23) {
					category_t.setText("Jcb , tow truck and big vehicle");
				}
				if (_position == 24) {
					category_t.setText("Loading vehicle");
				}
				if (_position == 25) {
					category_t.setText("Rental service");
				}
				if (_position == 26) {
					category_t.setText("Tent house party decorator");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				submit_d.setTitle("SUBMIT STORE DETAILS");
				submit_d.setMessage("Have you checked the store information well? If not, check again and submit it.");
				submit_d.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if (owner_name_t.getText().toString().length() > 30) {
							SketchwareUtil.showMessage(getApplicationContext(), "The maximum number of letters in owner name is 30");
						}
						else {
							if (profile_photo.getString("profile", "").equals("")) {
								SketchwareUtil.showMessage(getApplicationContext(), "add your profile photo");
							}
							else {
								if (store_photo.getString("store", "").equals("")) {
									SketchwareUtil.showMessage(getApplicationContext(), "add your store photo");
								}
								else {
									if (store_name_t.getText().toString().equals("")) {
										SketchwareUtil.showMessage(getApplicationContext(), "Enter your store name");
									}
									else {
										if (owner_name_t.getText().toString().equals("")) {
											SketchwareUtil.showMessage(getApplicationContext(), "Enter your store owner name");
										}
										else {
											if (email_address_t.getText().toString().equals("")) {
												SketchwareUtil.showMessage(getApplicationContext(), "Enter your store email address");
											}
											else {
												if (category_t.getText().toString().equals("")) {
													SketchwareUtil.showMessage(getApplicationContext(), "Enter your store category");
												}
												else {
													if (country_code_t.getText().toString().equals("")) {
														SketchwareUtil.showMessage(getApplicationContext(), "Enter your country code");
													}
													else {
														if (mobile_number_t.getText().toString().equals("")) {
															SketchwareUtil.showMessage(getApplicationContext(), "Enter your mobile number");
														}
														else {
															if (whatsapp_number_t.getText().toString().equals("")) {
																SketchwareUtil.showMessage(getApplicationContext(), "Enter your WhatsApp number");
															}
															else {
																if (store_number_t.getText().toString().equals("")) {
																	SketchwareUtil.showMessage(getApplicationContext(), "Enter your store number");
																}
																else {
																	if (area_t.getText().toString().equals("")) {
																		SketchwareUtil.showMessage(getApplicationContext(), "Enter your store area");
																	}
																	else {
																		if (city_t.getText().toString().equals("")) {
																			SketchwareUtil.showMessage(getApplicationContext(), "Enter your store city");
																		}
																		else {
																			if (state_t.getText().toString().equals("")) {
																				SketchwareUtil.showMessage(getApplicationContext(), "Enter your store state");
																			}
																			else {
																				if (country_t.getText().toString().equals("")) {
																					SketchwareUtil.showMessage(getApplicationContext(), "Enter your store country");
																				}
																				else {
																					if (store_services_t.getText().toString().equals("")) {
																						SketchwareUtil.showMessage(getApplicationContext(), "Enter your store services and description");
																					}
																					else {
																						if (payment.getString("payment", "").equals("")) {
																							SketchwareUtil.showMessage(getApplicationContext(), "add your payment receiving");
																						}
																						else {
																							user_key = NEW_STORE_DATA_DB.push().getKey();
																							calendar = Calendar.getInstance();
																							store_map = new HashMap<>();
																							store_map.put("user key", FirebaseAuth.getInstance().getCurrentUser().getUid());
																							store_map.put("owner name", owner_name_t.getText().toString());
																							store_map.put("email address", email_address_t.getText().toString());
																							store_map.put("store name", store_name_t.getText().toString());
																							store_map.put("country code", country_code_t.getText().toString());
																							store_map.put("mobile number", mobile_number_t.getText().toString());
																							store_map.put("whatsapp number", whatsapp_number_t.getText().toString());
																							store_map.put("store category", category_t.getText().toString());
																							store_map.put("store number", store_number_t.getText().toString());
																							store_map.put("store area", area_t.getText().toString());
																							store_map.put("store city", city_t.getText().toString());
																							store_map.put("store state", state_t.getText().toString());
																							store_map.put("store country", country_t.getText().toString());
																							store_map.put("store services", store_services_t.getText().toString());
																							store_map.put("upi id", upi_edittext3.getText().toString());
																							store_map.put("reference", reference_edittext.getText().toString());
																							store_map.put("date", new SimpleDateFormat("dd / MMM / yyyy  ( hh : mm a )").format(calendar.getTime()));
																							store_map.put("store pp image", profile_photo.getString("profile", ""));
																							store_map.put("store image", store_photo.getString("store", ""));
																							store_map.put("payment receiving", payment.getString("payment", ""));
																							NEW_STORE_DATA_DB.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(store_map);
																							store_map.clear();
																							t1 = new TimerTask() {
																								@Override
																								public void run() {
																									runOnUiThread(new Runnable() {
																										@Override
																										public void run() {
																											_Toast("ffffff", "0d47a1", "successfully submit your store data");
																											profile_photo.edit().remove("profile").commit();
																											store_photo.edit().remove("store").commit();
																											payment.edit().remove("payment").commit();
																											_LocalNotification("⏰ कोटरा कांटेक्ट ग्रुप आपका हार्दिक स्वागत करता है", "24 घंटे के भीतर आपका बिजनेस KOTRAContacts ऐप पर आजाएगा...");
																										}
																									});
																								}
																							};
																							_timer.schedule(t1, (int)(1000));
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
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.VISIBLE);
				second_linear.setVisibility(View.GONE);
				button5.setTextColor(0xFF76FF03);
				button6.setTextColor(0xFFFFFFFF);
			}
		});
		
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				second_linear.setVisibility(View.VISIBLE);
				vscroll1.setVisibility(View.GONE);
				button6.setTextColor(0xFF76FF03);
				button5.setTextColor(0xFFFFFFFF);
			}
		});
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", _tag, _network_request_listener);
				textview7.setVisibility(View.GONE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", _tag, _network_request_listener);
				textview7.setVisibility(View.VISIBLE);
				textview7.setText("No internet connection");
			}
		};
		
		_NEW_STORE_DATA_DB_child_listener = new ChildEventListener() {
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
		NEW_STORE_DATA_DB.addChildEventListener(_NEW_STORE_DATA_DB_child_listener);
		
		_NEW_STORE_STORAGE_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				sp_loading.setText("uploading ".concat(String.valueOf((long)(_progressValue)).concat(" %")));
				linear41.setVisibility(View.VISIBLE);
			}
		};
		
		_NEW_STORE_STORAGE_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_NEW_STORE_STORAGE_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				store_photo.edit().putString("store", _downloadUrl).commit();
				sp_loading.setText("store photo uploading successful");
				sp_loading.setTextColor(0xFF76FF03);
				progressbar2.setVisibility(View.GONE);
				_Toast("ffffff", "0d47a1", "Successfully upload store photo");
			}
		};
		
		_NEW_STORE_STORAGE_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_NEW_STORE_STORAGE_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_NEW_STORE_STORAGE_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_NEW_PROFILE_STORAGE_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				pp_loading.setText("uploading ".concat(String.valueOf((long)(_progressValue)).concat(" %")));
				linear40.setVisibility(View.VISIBLE);
			}
		};
		
		_NEW_PROFILE_STORAGE_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_NEW_PROFILE_STORAGE_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				profile_photo.edit().putString("profile", _downloadUrl).commit();
				_Toast("ffffff", "0d47a1", "Successfully upload profile photo");
				progressbar1.setVisibility(View.GONE);
				pp_loading.setText("profile photo uploading successful");
				pp_loading.setTextColor(0xFF76FF03);
			}
		};
		
		_NEW_PROFILE_STORAGE_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_NEW_PROFILE_STORAGE_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_NEW_PROFILE_STORAGE_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_PAY_DATA_STORAGE_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				textview9.setText("uploading ".concat(String.valueOf((long)(_progressValue)).concat(" %")));
				linear31.setVisibility(View.VISIBLE);
			}
		};
		
		_PAY_DATA_STORAGE_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_PAY_DATA_STORAGE_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				payment.edit().putString("payment", _downloadUrl).commit();
				_Toast("ffffff", "0d47a1", "successfully upload payment receiving");
				progressbar4.setVisibility(View.GONE);
				textview9.setText("payment receiving uploading successful");
				textview9.setTextColor(0xFF76FF03);
			}
		};
		
		_PAY_DATA_STORAGE_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_PAY_DATA_STORAGE_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_PAY_DATA_STORAGE_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_STORE_OFFER_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				DBoffer = _childValue.get("offer").toString();
				DBamount = _childValue.get("amount").toString();
				if (!offersp.getString("Data", "").equals(_childValue.get("amount").toString())) {
					offer_d.setIcon(R.drawable.imgof);
					offer_d.setTitle(DBoffer);
					offer_d.setMessage(" ₹".concat(DBamount));
					offer_d.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							offersp.edit().putString("Data", DBamount).commit();
						}
					});
					offer_d.setCancelable(false);
					offer_d.create().show();
				}
				textview3.setText(_childValue.get("offer").toString());
				edittext1.setText(_childValue.get("amount").toString());
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				DBoffer = _childValue.get("offer").toString();
				DBamount = _childValue.get("amount").toString();
				if (!offersp.getString("Data", "").equals(_childValue.get("amount").toString())) {
					offer_d.setIcon(R.drawable.imgof);
					offer_d.setTitle(DBoffer);
					offer_d.setMessage(" ₹".concat(DBamount));
					offer_d.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							offersp.edit().putString("Data", DBamount).commit();
						}
					});
					offer_d.setCancelable(false);
					offer_d.create().show();
				}
				textview3.setText(_childValue.get("offer").toString());
				edittext1.setText(_childValue.get("amount").toString());
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				DBoffer = _childValue.get("offer").toString();
				DBamount = _childValue.get("amount").toString();
				if (!offersp.getString("Data", "").equals(_childValue.get("amount").toString())) {
					offer_d.setIcon(R.drawable.imgof);
					offer_d.setTitle(DBoffer);
					offer_d.setMessage(" ₹".concat(DBamount));
					offer_d.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							offersp.edit().putString("Data", DBamount).commit();
						}
					});
					offer_d.setCancelable(false);
					offer_d.create().show();
				}
				textview3.setText(_childValue.get("offer").toString());
				edittext1.setText(_childValue.get("amount").toString());
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		STORE_OFFER.addChildEventListener(_STORE_OFFER_child_listener);
		
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
		_services_spinner();
		network.startRequestNetwork(RequestNetworkController.GET, "https://kotracontacts-app.firebaseio.com/", "KOTRA Contacts App", _network_request_listener);
		linear31.setVisibility(View.GONE);
		linear40.setVisibility(View.GONE);
		linear41.setVisibility(View.GONE);
		textview7.setVisibility(View.GONE);
		vscroll1.setVisibility(View.VISIBLE);
		second_linear.setVisibility(View.GONE);
		main_loading_linear.setVisibility(View.GONE);
		button5.setTextColor(0xFF76FF03);
		_ClickColor(button1, "#0d47a1", "#ffffff", "#9e9e9e", "#ffffff", 4, 80);
		_ClickColor(button4, "#0d47a1", "#ffffff", "#9e9e9e", "#ffffff", 4, 80);
		_ClickColor(button5, "#0d47a1", "#ffffff", "#9e9e9e", "#ffffff", 4, 80);
		_ClickColor(button6, "#0d47a1", "#ffffff", "#9e9e9e", "#ffffff", 4, 80);
		_radius("#ffffff", 4, button_linear);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_SCREENSHOT_PICKER:
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
				apath = _filePath.get((int)(0));
				aname = Uri.parse(_filePath.get((int)(0))).getLastPathSegment();
				imageview13.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(apath, 1024, 1024));
				PAY_DATA_STORAGE.child(aname).putFile(Uri.fromFile(new File(apath))).addOnFailureListener(_PAY_DATA_STORAGE_failure_listener).addOnProgressListener(_PAY_DATA_STORAGE_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return PAY_DATA_STORAGE.child(aname).getDownloadUrl();
					}}).addOnCompleteListener(_PAY_DATA_STORAGE_upload_success_listener);
			}
			else {
				_Toast("ffffff", "0d47a1", "Uploading Cancel...");
			}
			break;
			
			case REQ_CD_PROFILE_PHOTO_PICKER:
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
				bpath = _filePath.get((int)(0));
				bname = Uri.parse(_filePath.get((int)(0))).getLastPathSegment();
				ppimage.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(bpath, 1024, 1024));
				NEW_PROFILE_STORAGE.child(bname).putFile(Uri.fromFile(new File(bpath))).addOnFailureListener(_NEW_PROFILE_STORAGE_failure_listener).addOnProgressListener(_NEW_PROFILE_STORAGE_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return NEW_PROFILE_STORAGE.child(bname).getDownloadUrl();
					}}).addOnCompleteListener(_NEW_PROFILE_STORAGE_upload_success_listener);
			}
			else {
				_Toast("ffffff", "0d47a1", "Uploading Cancel...");
			}
			break;
			
			case REQ_CD_STORE_PHOTO_PICKER:
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
				cpath = _filePath.get((int)(0));
				cname = Uri.parse(_filePath.get((int)(0))).getLastPathSegment();
				spimage.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(cpath, 1024, 1024));
				NEW_STORE_STORAGE.child(cname).putFile(Uri.fromFile(new File(cpath))).addOnFailureListener(_NEW_STORE_STORAGE_failure_listener).addOnProgressListener(_NEW_STORE_STORAGE_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return NEW_STORE_STORAGE.child(cname).getDownloadUrl();
					}}).addOnCompleteListener(_NEW_STORE_STORAGE_upload_success_listener);
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
		textview7.setVisibility(View.GONE);
	}
	public void _Send (final Intent _IntentName, final String _to, final String _subject, final String _text) {
		_IntentName.setAction(Intent.ACTION_VIEW);
		_IntentName.setData(Uri.parse("mailto:".concat(_to)));
		_IntentName.putExtra("android.intent.extra.SUBJECT", _subject);
		_IntentName.putExtra("android.intent.extra.TEXT", _text);
		startActivity(_IntentName);
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
	
	
	public void _LocalNotification (final String _Title, final String _Text) {
		int notifyId = 001;
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		Notification.Builder builder = new Notification.Builder(PementActivity.this);
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
	
	
	public void _services_spinner () {
		categorylist.add("CHOICE YOUR BUSINESS CATEGORY");
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
		categorylist.add("If your business is not in it, then you type your category...📣");
		spinner2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, categorylist));
		((ArrayAdapter)spinner2.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _customNav (final String _color) {
		//Code From StackOverFlow.com And Converted By TeamWorks DEV
		if (Build.VERSION.SDK_INT >= 21) {
			Window w = this.getWindow();
			w.setNavigationBarColor(Color.parseColor(_color));
		}
	}
	
	
	public void _radius (final String _color, final double _numb, final View _view) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
		_view.setElevation((int)_numb);
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