package android.kjpm.com.cryptowallet;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtWalletAddress;
    Button btnSubmit;
    Spinner currency;
    static String API = "http://cryptowallet.tk/";
    String myCurrency,
            myAddress,
            Addrs,
            totalReceived,
            totalSent,
            balance,
            unconfirmedBalance,
            finalBalance,
            nTx,
            unconfirmedNTx,
            finalNTx,
            errMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        txtWalletAddress = (EditText) this.findViewById(R.id.editText);
        currency = (Spinner) this.findViewById(R.id.spinner);
        btnSubmit = (Button) this.findViewById(R.id.button);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent addWallet = new Intent(getBaseContext(), AddWallet.class);
                startActivity(addWallet);
//                myCurrency = currency.getSelectedItem().toString();
//                myAddress = txtWalletAddress.getText().toString();
//
//                if(myAddress.equals("")) {
//                    Toast.makeText(MainActivity.this, "Please Enter Your " + myCurrency + " Address", Toast.LENGTH_SHORT).show();
//                } else {
//                    if(isOnline()) {
//
////                        GetWalletBalance task = new GetWalletBalance();
////                        task.execute("");
//                    }
//                    else
//                    {
//                        Toast.makeText(this,"No Internet Connection..", Toast.LENGTH_LONG).show();
//                    }
//                }

                break;
        }
    }

    protected boolean isOnline()
    {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if(netInfo != null && netInfo.isConnectedOrConnecting()){
            return true;
        }else
        {
            return false;
        }
    }

    class GetWalletBalance extends AsyncTask<String, Void, String> {
        int flag = 0;
        String res;
        String getBalanceAddress = API + "addr/" + myCurrency + "/" + myAddress + "/balance";
        HttpURLConnection con;
        StringBuffer buffer;


        @Override
        protected String doInBackground(String... params) {


            try{
                URL url = new URL(getBalanceAddress);
                con = (HttpURLConnection) url.openConnection();

                InputStream is = con.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                buffer = new StringBuffer();
                String line = "";
                while((line = reader.readLine())!=null){
                    buffer.append(line);
                }

                reader.close();
                // return "suc";
            }catch (MalformedURLException e){
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }finally {
                if(con!=null){
                    con.disconnect();
                }

            }
            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // readAndParseJSON(s);
            readAndParseJSON(buffer.toString());
//            Toast.makeText(MainActivity.this,res,Toast.LENGTH_LONG).show();
            if(flag == 1)
            {

//                Intent announement = new Intent(getBaseContext(), Announcement.class);
//                announement.putExtra("Fname",Firstname);
//                announement.putExtra("Lname",Lastname);
//                announement.putExtra("Mname",Midname);
//                announement.putExtra("idnum", idno);
//                announement.putExtra("pos", position);
//                posi = position;
//                announement.putExtra("org_id", org_id);
//                announement.putExtra("userId",userId);
//                announement.putExtra("userimg",userImg);
//                finish();
//
//                startActivity(announement);
            }



        }

        public void readAndParseJSON(String string){

            //Firstname = "hello world";
            JSONObject obj = null;
            Toast.makeText(MainActivity.this, "hasdasd", Toast.LENGTH_LONG).show();
            try {
                obj = new JSONObject(string);
                Addrs = obj.getString("address");

                if(Addrs.equals(myAddress)) {
                    res = "Successfully Logged In!";
                    totalReceived = obj.getString("total_received");
                    totalSent = obj.getString("total_sent");
                    balance = obj.getString("balance");
                    unconfirmedBalance = obj.getString("unconfirmed_balance");//Integer.parseInt(obj.getString("idno").toString());
                    finalBalance = obj.getString("final_balance");
                    nTx = obj.getString("n_tx");
                    unconfirmedNTx = obj.getString("unconfirmed_n_tx");
                    finalNTx = obj.getString("final_n_tx");
                    flag = 1;
                    Double myCryptoBalance = Double.parseDouble(balance) / 100000000;
                    Toast.makeText(MainActivity.this, myCryptoBalance.toString(), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    errMsg = obj.getString("error");
                    res = errMsg;
                    Toast.makeText(MainActivity.this, res.toString(), Toast.LENGTH_SHORT).show();
                }

            } catch (JSONException e) {
                e.printStackTrace();
                res = "Useraccount Not found!";

            }




        }
    }
}
