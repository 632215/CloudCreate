package com.panda.ijk.media;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.panda.ijk.R;

import java.util.HashMap;
import java.util.Locale;

import tv.danmaku.ijk.media.player.IMediaPlayer;

import static android.provider.MediaStore.Images.Thumbnails.MINI_KIND;

public class ExtendIjkVideoView extends FrameLayout {

    /**
     * Handler message target
     */
    private static final int MESSAGE_UPDATE_VIDEO_THUMBNAIL = 1;
    private static final int MESSAGE_HIDE_CENTER_BOX = 2;
    private static final int MESSAGE_SEEK_NEW_POSITION = 3;
    private final int mMaxVolume;
    /**
     * Extend ijk video views
     */
    private IjkVideoView mViewVideo;
    private ProgressBar imgLoadProgress;
    private FrameLayout layoutThumbnail;
    private ImageButton iBtnClose;
    /**
     * Center box views
     */
    private FrameLayout layoutVideoCenterBox;
    // volume box
    private TextView txtVideoVolume;
    // fast forward box
    private RelativeLayout layoutVideoFastForwardBox;
    private TextView txtFastForward, txtFastForwardTarget, txtFastForwardAll;
    // brightness
    private TextView txtVideoBrightness;
    // load video buffer progress ani
    private Animation loadAnim;
    /**
     * Data Filed
     */
    // cached width and height
    private int oldWidth = -1, oldHeight = -1;
    // volume filed
    private AudioManager audioManager;
    private int volume = -1;
    // video progress filed
    private long newPosition = -1;
    // brightness filed
    private float brightness = -1;
    private boolean isAlive;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_UPDATE_VIDEO_THUMBNAIL:

                    break;
                case MESSAGE_HIDE_CENTER_BOX:
                    if (layoutVideoCenterBox != null) {
                        layoutVideoCenterBox.setVisibility(GONE);
                    }
                    break;
                case MESSAGE_SEEK_NEW_POSITION:
                    if (newPosition >= 0 && mViewVideo != null) {
                        mViewVideo.seekTo((int) newPosition);
                        newPosition = -1;
                    }
            }
            return true;
        }
    });

    public ExtendIjkVideoView(Context context) {
        this(context, null);
    }

    public ExtendIjkVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExtendIjkVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_extend_ijkvideo, this);

        imgLoadProgress = findViewById(R.id.video_progress);
        mViewVideo = findViewById(R.id.view_video);
        layoutThumbnail = findViewById(R.id.layout_thumbnail);

        layoutVideoCenterBox = findViewById(R.id.layout_video_center_box);
        txtVideoVolume = findViewById(R.id.txt_video_volume);

        layoutVideoFastForwardBox = findViewById(R.id.layout_video_fast_forward_box);
        txtFastForward = findViewById(R.id.txt_video_fast_forward);
        txtFastForwardTarget = findViewById(R.id.txt_video_fast_forward_target);
        txtFastForwardAll = findViewById(R.id.txt_video_fast_forward_all);

        txtVideoBrightness = findViewById(R.id.txt_video_brightness);

        layoutThumbnail.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });

        iBtnClose = (ImageButton) findViewById(R.id.ibtn_close);

        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        mMaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // cached old size
        if (oldHeight == -1 && oldWidth == -1) {
            oldWidth = w;
            oldHeight = h;
        }
    }

    public void play() {
        mViewVideo.start();
        layoutThumbnail.setVisibility(GONE);
    }

    public void play(Uri uri) {
        setVideo(uri);
        play();
    }

    /**
     * Must call this method when setting view's width and height
     */
    public void setSize(int width, int height) {
        oldWidth = width;
        oldHeight = height;

        getLayoutParams().width = oldWidth;
        getLayoutParams().height = oldHeight;
    }

    public IjkVideoView getVideoView() {
        return mViewVideo;
    }

    private void showLoadingProgress() {
        imgLoadProgress.setVisibility(View.VISIBLE);
        /*if (loadAnim == null) {
            loadAnim = new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 1f,
                    Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0);
            loadAnim.setDuration(3000);
            loadAnim.setRepeatCount(-1);
            loadAnim.setRepeatMode(Animation.RESTART);
            imgLoadProgress.setAnimation(loadAnim);
        }
        loadAnim.start();*/
    }

    private void hideLoadingProgress() {
        imgLoadProgress.setVisibility(View.GONE);

      /*  if (loadAnim != null) {
            loadAnim.cancel();
        }*/
    }

    public void loadVideoThumbnail(final Uri uri) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap videoThumbnail = createVideoThumbnail(uri.toString(), MINI_KIND);
                Message message = Message.obtain();
                message.what = MESSAGE_UPDATE_VIDEO_THUMBNAIL;
                message.obj = videoThumbnail;
                mHandler.sendMessage(message);
            }
        }).start();
    }

    /**
     * Setting about video
     *
     * @param uri video local or remote path
     */
    public void setVideo(Uri uri) {

//        loadVideoThumbnail(uri);

        mViewVideo.setVideoURI(uri);
        AndroidMediaController androidMediaController = new AndroidMediaController(getContext(), false);
        androidMediaController.addMediaControllerStatusListener(new AndroidMediaController.MediaControllerStatusListener() {
            @Override
            public void onStatusChanged(int status) {
                switch (status) {
                    case AndroidMediaController.STATUS_HIDE:
                        iBtnClose.setVisibility(GONE);
                        break;
                    case AndroidMediaController.STATUS_SHOW:
                        iBtnClose.setVisibility(VISIBLE);
                        break;
                    default:
                        break;
                }
            }
        });
        androidMediaController.showTime(!isAlive);
        mViewVideo.setMediaController(androidMediaController);
        /**
         * Setting ijk video listener
         */
        mViewVideo.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer mp) {
//                mViewVideo.start();
            }
        });

        mViewVideo.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                if (onVideoFinishListener != null) {
                    onVideoFinishListener.onVideoFinish();
                }
                layoutThumbnail.setVisibility(VISIBLE);
            }
        });

        mViewVideo.setOnErrorListener(new IMediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
                if (onVideoFinishListener != null) {
                    onVideoFinishListener.onVideoFinish();
                }
                hideLoadingProgress();
                return false;
            }
        });

        mViewVideo.setOnInfoListener(new IMediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(IMediaPlayer iMediaPlayer, int what, int extra) {
                switch (what) {
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START:
                        showLoadingProgress();
                        break;
                    case IMediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START:
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END:
                        hideLoadingProgress();
                        break;
                }
                return false;
            }
        });

        mViewVideo.setOnSlideVolumeChangedListener(new IjkVideoView.OnSlideVolumeChangedListener() {
            @Override
            public void onSlideVolumeChanged(float percent) {
                onVolumeSlide(percent);
            }

            @Override
            public void onSlideFinish() {
                volume = -1;

                hideCenterBox();
            }
        });

        mViewVideo.setOnSlideProgressChangedListener(new IjkVideoView.OnSlideProgressChangedListener() {
            @Override
            public void onSlideProgressChanged(float percent) {
                onProgressSlide(percent);
            }

            @Override
            public void onSlideFinish() {
                if (newPosition >= 0) {
                    mHandler.removeMessages(MESSAGE_SEEK_NEW_POSITION);
                    mHandler.sendEmptyMessage(MESSAGE_SEEK_NEW_POSITION);
                }

                hideCenterBox();
            }
        });

        mViewVideo.setOnSlideBrightnessChangedListener(new IjkVideoView.OnSlideBrightnessChangedListener() {
            @Override
            public void onSlideBrightnessChanged(float percent) {
                onBrightnessSlide(percent);
            }

            @Override
            public void onSlideFinish() {
                brightness = -1f;
                hideCenterBox();
            }
        });
    }

    private void hideCenterBox() {
        mHandler.removeMessages(MESSAGE_HIDE_CENTER_BOX);
        mHandler.sendEmptyMessageDelayed(MESSAGE_HIDE_CENTER_BOX, 500);
    }

    /**
     * Create a video thumbnail for a video. May return null if the video is
     * corrupt or the format is not supported.
     *
     * @param filePath the path of video file
     * @param kind     could be MINI_KIND or MICRO_KIND
     */
    public Bitmap createVideoThumbnail(String filePath, int kind) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            if (filePath.startsWith("http://")
                    || filePath.startsWith("https://")
                    || filePath.startsWith("widevine://")) {
                retriever.setDataSource(filePath, new HashMap<String, String>());
            } else {
                retriever.setDataSource(filePath);
            }
            bitmap = retriever.getFrameAtTime();
        } catch (RuntimeException ex) {
            // Assume this is a corrupt video file.
            ex.printStackTrace();
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                // Ignore failures while cleaning up.
                ex.printStackTrace();
            }
        }

        if (bitmap == null) return null;

        if (kind == MINI_KIND) {
            // Scale down the bitmap if it's too large.
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int max = Math.max(width, height);
            if (max > 512) {
                float scale = 512f / max;
                int w = Math.round(scale * width);
                int h = Math.round(scale * height);
                bitmap = Bitmap.createScaledBitmap(bitmap, w, h, true);
            }
        } else if (kind == MediaStore.Images.Thumbnails.MICRO_KIND) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap,
                    96,
                    96,
                    ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        }
        return bitmap;
    }

    public void setIsAlive(boolean alive) {
        isAlive = alive;
        IMediaController mediaController = mViewVideo.getMediaController();
        if (mediaController != null) {
            ((AndroidMediaController) mediaController).showTime(!alive);
        }
    }

    /**
     * Set windows on configuration changed
     *
     * @param newConfig the {@link Configuration}
     */
    public void setOnConfigurationChanged(@NonNull Configuration newConfig) {
        mViewVideo.onConfigurationChanged(newConfig);

        Activity activity = null;

        if (getContext() instanceof Activity) {
            activity = ((Activity) getContext());
        }
        if (activity == null) return;

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // set current windows fullscreen
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        } else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getLayoutParams().height = oldHeight;
            getLayoutParams().width = oldWidth;
        }
    }

    /**
     * Change volume and ui when slide callback
     */
    private void onVolumeSlide(float percent) {
        if (volume == -1) {
            volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            if (volume < 0) volume = 0;
        }

        int index = (int) (percent * mMaxVolume) + volume;
        if (index > mMaxVolume) {
            index = mMaxVolume;
        } else if (index < 0) {
            index = 0;
        }

        // change media volume
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, index, 0);

        // change ui
        int i = (int) (index * 1.0 / mMaxVolume * 100);
        String s = i == 0 ? "off" : i + "%";

        layoutVideoCenterBox.setVisibility(VISIBLE);
        txtVideoVolume.setVisibility(VISIBLE);
        layoutVideoFastForwardBox.setVisibility(GONE);
        txtVideoBrightness.setVisibility(GONE);

        Drawable drawable = ContextCompat.getDrawable(getContext(), i == 0 ? R.drawable.ic_volume_off_white : R.drawable.ic_volume_up_white);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        txtVideoVolume.setCompoundDrawables(null, drawable, null, null);
        txtVideoVolume.setText(s);
    }

    /**
     * Change progress and ui when slide callback
     */
    private void onProgressSlide(float percent) {
        long position = mViewVideo.getCurrentPosition();
        long duration = mViewVideo.getDuration();
        long deltaMax = Math.min(100 * 1000, duration - position);
        long delta = (long) (deltaMax * percent);

        newPosition = delta + position;
        if (newPosition > duration) {
            newPosition = duration;
        } else if (newPosition <= 0) {
            newPosition = 0;
            delta = -position;
        }

        int showDelta = (int) delta / 1000;
        if (showDelta != 0) {
            layoutVideoCenterBox.setVisibility(VISIBLE);
            layoutVideoFastForwardBox.setVisibility(VISIBLE);
            txtVideoVolume.setVisibility(GONE);
            txtVideoBrightness.setVisibility(GONE);

            String text = showDelta > 0 ? ("+" + showDelta) : "" + showDelta;
            txtFastForward.setText(String.format(Locale.getDefault(), "%ss", text));
            txtFastForwardTarget.setText(String.format(Locale.getDefault(), "%s/", generateTime(newPosition)));
            txtFastForwardAll.setText(generateTime(duration));
        }
    }

    /**
     * Conversion time millis to video time string
     *
     * @param time time millis
     * @return video time string
     */
    private String generateTime(long time) {
        int totalSeconds = (int) (time / 1000);
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        return hours > 0 ?
                String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds) :
                String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
    }

    /**
     * Change brightness and ui when slide callback
     */
    private void onBrightnessSlide(float percent) {

        Activity activity = null;
        if (getContext() instanceof Activity) {
            activity = ((Activity) getContext());
        }

        if (activity == null) return;

        if (brightness < 0) {
            brightness = activity.getWindow().getAttributes().screenBrightness;
            if (brightness <= 0.00f) {
                brightness = 0.50f;
            } else if (brightness < 0.01f) {
                brightness = 0.01f;
            }
        }

        // change screen brightness
        WindowManager.LayoutParams lpa = activity.getWindow().getAttributes();
        lpa.screenBrightness = brightness + percent;
        if (lpa.screenBrightness > 1.0f) {
            lpa.screenBrightness = 1.0f;
        } else if (lpa.screenBrightness < 0.01f) {
            lpa.screenBrightness = 0.01f;
        }
        activity.getWindow().setAttributes(lpa);

        // changed ui
        layoutVideoCenterBox.setVisibility(VISIBLE);
        txtVideoBrightness.setVisibility(VISIBLE);
        layoutVideoFastForwardBox.setVisibility(GONE);
        txtVideoVolume.setVisibility(GONE);

        txtVideoBrightness.setText(String.format(Locale.getDefault(), "%d%%", (int) (lpa.screenBrightness * 100)));
    }

    public void setOnCloseButtonClickListener(OnClickListener listener) {
        if (listener != null) {
            iBtnClose.setOnClickListener(listener);
        }
    }

    public interface OnVideoFinishListener {
        void onVideoFinish();
    }

    private OnVideoFinishListener onVideoFinishListener;

    public void setOnVideoFinishListener(OnVideoFinishListener onFinishListener) {
        this.onVideoFinishListener = onFinishListener;
    }

}
