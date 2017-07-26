package com.i8080soft.tabhost;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class personalset extends Activity {
	private ImageView imapic;
	private EditText  name,mobile,credit,adddress,birthday,eMial;
	private RadioButton sexMAN,sexgril;
	private RadioGroup radiogroup;
	private Button save;
	private  static String showname,showmobile,showcredit,showadddress,showbirthday,showeMial;
	private SharedPreferences preferences,preferences1 ;
	private  static boolean totaldata=false;
	private  static boolean logindata=false;
	private  static boolean backdata=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personalset);
		preferences = getApplicationContext()
				.getSharedPreferences("Registerdata", Context.MODE_PRIVATE);  
		preferences1 = getApplicationContext()
				.getSharedPreferences("logindata", Context.MODE_PRIVATE);  
		initUI();
		//第一次创建，判空。 
		if( savedInstanceState != null )
		{ 
			save.setEnabled(true);
			name.setText(savedInstanceState.getString("userName"));
		    credit.setText(savedInstanceState.getString("userIdcard"));
		    mobile.setText(savedInstanceState.getString("userMobile"));
		    eMial.setText(savedInstanceState.getString("eMial"));
		    adddress.setText(savedInstanceState.getString("adddress"));
			birthday.setText(savedInstanceState.getString("birthday"));
		 
		}

		/*if(backdata==true)
		{
			save.setEnabled(false);
			name.setText("");
			credit.setText("");
			mobile.setText("");
			eMial.setText("");
			adddress.setText("");
			birthday.setText("");
		}*/
		
		//hava register
		if(logindata==true)
		{
			save.setEnabled(true);
			name.setText(preferences1.getString("userNamelogin", null));
		    credit.setText(preferences1.getString("userIdcardlogin", null));
		    mobile.setText(preferences1.getString("userMobilelogin", null));
		    eMial.setText(preferences1.getString("eMiallogin", null));
		    adddress.setText(preferences1.getString("adddresslogin", null));
			birthday.setText(preferences1.getString("birthdaylogin", null));
		}
		
		if(totaldata==true)//全局变量
		{
			save.setEnabled(true);
		
		}else
			//no register   所有都清空
		{
			
			save.setEnabled(false);
			name.setText("");
			credit.setText("");
			mobile.setText("");
			eMial.setText("");
			adddress.setText("");
			birthday.setText("");
		}
		
	
		initEvent();
	}
	
	public void initUI()
	{
		imapic=(ImageView)findViewById(R.id.photoImg);
		name=(EditText)findViewById(R.id.nameSetEdit);
		sexMAN=(RadioButton)findViewById(R.id.boy);
		sexgril=(RadioButton)findViewById(R.id.girl);
		radiogroup=(RadioGroup)findViewById(R.id.sexSelect);
		mobile=(EditText)findViewById(R.id.phoneSetEdit);
		credit=(EditText)findViewById(R.id.idCardSetEdit);
		adddress=(EditText)findViewById(R.id.adressSetEdit);
		birthday=(EditText)findViewById(R.id.birthdaySetEdit);
		eMial=(EditText)findViewById(R.id.eMialSetEdit);
		save=(Button)findViewById(R.id.saveSet);
	}
	public void initEvent()
	{
	   // SharedPreferences preferences = getApplicationContext().getSharedPreferences("Registerdata", Context.MODE_PRIVATE);  
	    showname= preferences.getString("userName", null);  
	    showcredit= preferences.getString("userIdcard", null);  
	    showmobile= preferences.getString("userMobile", null);  
	    totaldata= preferences.getBoolean("isall", true);
	    
	    logindata= preferences1.getBoolean("islogin", true);
	    
	    
	    
	    
	    
	    
	    if(totaldata==true)
	    {
	    	save.setEnabled(true);
	    }
	    name.setText(showname);
	    credit.setText(showcredit);
	    mobile.setText(showmobile);
	    imapic.setImageResource(R.drawable.ic_launcher);
	  
	    radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {  
            
            @Override 
            public void onCheckedChanged(RadioGroup group, int checkedId) {  
                // TODO Auto-generated method stub  
                if(checkedId==R.id.boy){                    
                	
                }  
                else if(checkedId==R.id.girl){  
                   
                }  
                  
            }  
        }); 
	    save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 
			    SharedPreferences.Editor editor = preferences.edit();  
			    editor.putString("adddress", adddress.getText().toString()); 
			    editor.putString("birthday", birthday.getText().toString());  
			    editor.putString("eMial", eMial.getText().toString()); 
			    editor.commit();  
			    
			    SharedPreferences.Editor editor1 = preferences1.edit();  
			    editor1.putString("adddresslogin", adddress.getText().toString()); 
			    editor1.putString("birthdaylogin", birthday.getText().toString());  
			    editor1.putString("eMiallogin", eMial.getText().toString());
			    editor1.putString("userNamelogin", adddress.getText().toString()); 
			    editor1.putString("userIdcardlogin", birthday.getText().toString());  
			    editor1.putString("userMobilelogin", eMial.getText().toString());
			    editor1.commit();  
				Toast.makeText(personalset.this, "已成功保存个人信息", Toast.LENGTH_SHORT).show();
			}
		});
	    
	}
	//shujuhuancun
	@Override
    protected void onSaveInstanceState(Bundle outState) {
        
        if(preferences.getBoolean("islogin", true)==true)
        {
        	outState.putBoolean("islogin", true);
        
        }
        outState.putString("adddress",preferences1.getString("adddresslogin", null));
        outState.putString("birthday",preferences1.getString("birthdaylogin", null));
        outState.putString("eMial",preferences1.getString("eMiallogin", null));
        outState.putString("userName",preferences1.getString("userNamelogin", null));
        outState.putString("userIdcard",preferences1.getString("userIdcardlogin", null));
        outState.putString("userMobile",preferences1.getString("userMobilelogin", null));
        super.onSaveInstanceState(outState);
    }
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState){  
		save.setEnabled(true);
		name.setText(savedInstanceState.getString("userName"));
	    credit.setText(savedInstanceState.getString("userIdcard"));
	    mobile.setText(savedInstanceState.getString("userMobile"));
	    eMial.setText(savedInstanceState.getString("eMial"));
	    adddress.setText(savedInstanceState.getString("adddress"));
		birthday.setText(savedInstanceState.getString("birthday"));
		super.onRestoreInstanceState(savedInstanceState); 
	 
	}  
}
