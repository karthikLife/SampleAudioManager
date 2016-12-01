package study.org.myapplication;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

import static android.R.attr.button;
import static android.R.attr.mode;

public class MainActivity extends AppCompatActivity  {
    AudioManager mode = null;
    // Buttons to change Ringer mode
    View ringerNormalBtn;
    View vibrateBtn;
    View silentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mode = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        ringerNormalBtn = (View) findViewById(R.id.btnRingerMode);
        vibrateBtn = (View) findViewById(R.id.btnVibrateMode);
        silentBtn = (View) findViewById(R.id.btnSilentMode);
        int currentMode = mode.getRingerMode();


        if (currentMode == AudioManager.RINGER_MODE_NORMAL) {
            ringerNormalBtn.setBackgroundResource(R.color.yellow);
        } else if (currentMode == AudioManager.RINGER_MODE_SILENT) {
            silentBtn.setBackgroundResource(R.color.yellow);
        } else if (currentMode == AudioManager.RINGER_MODE_VIBRATE) {
            vibrateBtn.setBackgroundResource(R.color.yellow);
        }
    }
    public void makePhoneSilent(View view) {
        mode.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        ringerNormalBtn.setBackgroundResource(R.color.red);
        vibrateBtn.setBackgroundResource(R.color.red);
        view.setBackgroundResource(R.color.yellow);
    }

    public void makePhoneRinger(View view) {
        mode.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        silentBtn.setBackgroundResource(R.color.red);
        vibrateBtn.setBackgroundResource(R.color.red);
        view.setBackgroundResource(R.color.yellow);
    }

    public void makePhoneVibrate(View view) {
        mode.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        ringerNormalBtn.setBackgroundResource(R.color.red);
        silentBtn.setBackgroundResource(R.color.red);
        view.setBackgroundResource(R.color.yellow);

    }



}