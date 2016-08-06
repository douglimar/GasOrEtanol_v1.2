package br.com.douglimar.gasoretanol;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DisplayResult extends Activity {

	private AdView adview; 
	private String MY_AD_UNIT_ID = "a15006f6691178e";
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) { 
		
		super.onCreate(savedInstanceState);
		
		String s_tag = ""; 
		Intent intent = getIntent();
		
		String message = intent.getStringExtra(GasOrEtanolActivity.EXTRA_MESSAGE);
		
		setContentView(R.layout.result);
		
		s_tag = message.substring(0, message.indexOf(":"));
		
		message = message.substring(message.indexOf(":")+1, message.length());
		
		LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout); 

		if (s_tag.equals("GAS")) {
			ll.setBackgroundResource(R.drawable.bkg_gasolina3);
		} 
		else 
			if (s_tag.equals("ETA")) {
				ll.setBackgroundResource(R.drawable.bkg_etanol3);
			}						
		
        Button btnVoltar = (Button) findViewById(R.id.btnVoltar); 
        btnVoltar.setText("Voltar para Tela Principal");
        
        btnVoltar.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				
				finish();
				
			}
        }); 
        
        
        TextView tv = (TextView)findViewById(R.id.text);
        tv.setText(message);
        

        // Create a AdView
    	adview = new AdView(this, AdSize.BANNER, MY_AD_UNIT_ID);
    	ll.addView(adview);
        adview.loadAd(new AdRequest());   
        
		
	}

}
