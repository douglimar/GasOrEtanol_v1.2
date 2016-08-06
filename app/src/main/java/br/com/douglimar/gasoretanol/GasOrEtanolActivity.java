package br.com.douglimar.gasoretanol;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GasOrEtanolActivity extends Activity {
	
	// Cria uma variavel para fazer o transporte de valores
	// entre intents 
	public static final String EXTRA_MESSAGE = new String ("br.com.douglimar.gasoretanol.MESSAGE");

	double  vGas, vEtanol, resultado = 0.0;
	boolean continua; 
	
	EditText edtGasolina; 
	EditText edtEtanol;
	String   sResultado = "";
	
	//private AdView adview; 
	//private String MY_AD_UNIT_ID = "a15006f6691178e";	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);        
        
        // Create a AdView
    	adview = new AdView(this, AdSize.BANNER, MY_AD_UNIT_ID);
    	ll.addView(adview);
        adview.loadAd(new AdRequest()); */  
        
    }
    
    
    public void calcularCombustivel(View v) {
    	
    	try {
    		
    		continua    = true;
    		edtGasolina = (EditText) findViewById(R.id.edtGasValue);
    		edtEtanol   = (EditText) findViewById(R.id.edtEtanolValue);
    		
    		/*
    		
    		edtGasolina.setInputType(InputType.TYPE_CLASS_NUMBER);
    		
    		edtGasolina.addTextChangedListener(new TextWatcher() {
    			
    			private boolean isUpdating = false;
    			private NumberFormat nf = NumberFormat.getCurrencyInstance();
    			
				public void afterTextChanged(Editable s) {
					// TODO Auto-generated method stub
					if(isUpdating) {
						isUpdating = false;
				        return;
				    }
					
  			        isUpdating = true;
			        String str = s.toString();
			        // Verifica se já existe a máscara no texto.
			        boolean hasMask = (str.indexOf("R$") > -1 && str.indexOf(".") > -1 && str.indexOf(",") > -1);
					
			        if(hasMask) {
			            // Se já existir a máscara, precisamos retira-la.
			            str = str.replaceAll("[R$]", "").replaceAll("[,]", "").replaceAll("[.]", "");
			         }
			        
			        try {
			            // Transformamos o número que está escrito no EditText em monetário.
			            str = nf.format(Double.parseDouble(str) / 100);
			            edtGasolina.setText(str);
			            edtGasolina.setSelection(edtGasolina.getText().length());
			         } catch(NumberFormatException e) {
			            s.clear();
			         }
				}

				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {
					// TODO Auto-generated method stub
					
				}

				public void onTextChanged(CharSequence s, int start,
						int before, int count) {
					// TODO Auto-generated method stub
					
				}
    		}); */ 

    		vGas        = Double.parseDouble(edtGasolina.getText().toString());
    		vEtanol     = Double.parseDouble(edtEtanol.getText().toString());
    		
    	} catch (Exception e) {
    		Toast.makeText(getApplicationContext(), "Digite o valor da Gasolina e do Etanol.", Toast.LENGTH_LONG).show();
    		continua = false;
		}
    	
    	if ( continua == true ) {
    		
        	resultado = (vEtanol *100) / vGas; 
	    	
        	DecimalFormat df = new DecimalFormat("#.##");
        	    	
        	sResultado = df.format(resultado);
        	    	
        	if (resultado > 70.0) {

            	Intent intent = new Intent(this, DisplayResult.class);
          	
            	String message = "GAS: ABASTEÇA COM GASOLINA \n\n" +
        	    		"O etanol representa " + sResultado + "% do Valor da Gasolina";
            	
            	intent.putExtra(EXTRA_MESSAGE, message);
            	startActivity(intent);        		
    		} 
        	else {
            	Intent intent = new Intent(this, DisplayResult.class);
            	
            	String message = "ETA: ABASTEÇA COM ETANOL\n\n" +
        	    		"O etanol representa " + sResultado + "% do Valor da Gasolina";
            	
            	intent.putExtra(EXTRA_MESSAGE, message);
            	startActivity(intent);
			}
    	}
    }
}
    	
    	
