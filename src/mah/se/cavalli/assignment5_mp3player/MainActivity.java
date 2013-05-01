package mah.se.cavalli.assignment5_mp3player;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.ListActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;




public class MainActivity extends ListActivity {

	class Mp3Filter implements FilenameFilter {
		public boolean accept(File dir, String name){
			return (name.endsWith(".mp3"));
		}
	}
	
	private static final String SDCARD = new String ("/sdcard/");
	//private static final String SDCARD = new String(Environment.getExternalStorageDirectory().getPath() + "/sdcard/");
	private List<String> latarna = new ArrayList<String>();
	private MediaPlayer mp = new MediaPlayer();
	



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		 ImageButton btnPlay = (ImageButton) findViewById(R.drawable.play);
		 ImageButton btnPause = (ImageButton) findViewById(R.drawable.pause);
		 ImageButton btnPrev = (ImageButton) findViewById(R.drawable.prev);
		 ImageButton btnNext = (ImageButton) findViewById(R.drawable.next);
		
		playlistUpdater();
		
		
	
		 btnPause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mp.pause();	
			}
		});	
	
		 btnPlay.setOnClickListener(new OnClickListener() {
			
		@Override
		public void onClick(View v) {
			mp.start();	
		}
	});	

		 btnNext.setOnClickListener(new OnClickListener() {
			
		@Override
		public void onClick(View v) {
		//mp.();	
	}
});	
}

	private void playlistUpdater() {
		File home = new File(SDCARD);
		if(home.listFiles(new Mp3Filter()).length>0){
			for (File file:home.listFiles( new Mp3Filter())){
				latarna.add(file.getName());
			}
			
			ArrayAdapter<String> playList = new ArrayAdapter<String>(this, R.layout.spellista,latarna);
			setListAdapter(playList);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
