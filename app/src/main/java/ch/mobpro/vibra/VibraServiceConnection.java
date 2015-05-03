package ch.mobpro.vibra;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by remo on 04.05.2015.
 */
public class VibraServiceConnection implements ServiceConnection {
    VibraMusicService mService = null;
    boolean mBound;

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        VibraMusicService.LocalBinder binder = (VibraMusicService.LocalBinder) service;
        mService = binder.getService();
        mBound = true;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        mService = null;
        mBound = false;
    }

    public VibraMusicService getMService() {
        return mService;
    }

    public boolean getMbound() {
        return mBound;
    }
}