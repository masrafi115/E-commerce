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
import android.widget.TextView;
import android.widget.LinearLayout;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class TimepassActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	
	private TextView textview66;
	private LinearLayout main_loading_linear;
	private WebView webview1;
	private ImageView imageview1;
	private ProgressBar progressbar1;
	private TextView textview65;
	
	private TimerTask tg;
	private RequestNetwork internet;
	private RequestNetwork.RequestListener _internet_request_listener;
	private Intent game_i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.timepass);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		textview66 = (TextView) findViewById(R.id.textview66);
		main_loading_linear = (LinearLayout) findViewById(R.id.main_loading_linear);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		textview65 = (TextView) findViewById(R.id.textview65);
		internet = new RequestNetwork(this);
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				main_loading_linear.setVisibility(View.VISIBLE);
				if (webview1.getUrl().contains("")) {
					webview1.goBack();
				}
				else {
					game_i.setAction(Intent.ACTION_VIEW);
					game_i.setData(Uri.parse(webview1.getUrl()));
					startActivity(game_i);
				}
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				main_loading_linear.setVisibility(View.GONE);
				textview66.setVisibility(View.GONE);
				super.onPageFinished(_param1, _param2);
			}
		});
		
		_internet_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				textview66.setVisibility(View.GONE);
				main_loading_linear.setVisibility(View.GONE);
				tg = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								webview1.loadUrl("https://www.google.com/fbx?fbx=snake_arcade");
							}
						});
					}
				};
				_timer.schedule(tg, (int)(500));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				textview66.setText("No internet connection");
				main_loading_linear.setVisibility(View.VISIBLE);
				textview66.setVisibility(View.VISIBLE);
			}
		};
	}
	
	private void initializeLogic() {
		internet.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com/fbx?fbx=snake_arcade", "time pass", _internet_request_listener);
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