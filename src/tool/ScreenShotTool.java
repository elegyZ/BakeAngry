package tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

public class ScreenShotTool 
{
	public static void getPermission(Activity activity)
	{
		/*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) 
            {
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_CALL_PHONE);
            }else {
                //showToast("»®œﬁ“—…Í«Î");
            }
        }*/
	}
	
	public static Uri saveImageToGallery(Context context, Bitmap bitmap) 
	{
        //first store the image
        File folderDir = new File(Environment.getExternalStorageDirectory()+ "/DCIM/Camera/");
        if (!folderDir.exists()) {
        	folderDir.mkdir();
        	Toast.makeText(context, "folder is built", Toast.LENGTH_SHORT);
        }
        String pictureName = System.currentTimeMillis() + ".jpg";
        File picturefile = new File(folderDir, pictureName);
        try 
        {
            FileOutputStream fos = new FileOutputStream(picturefile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);				//form,quality%,stream
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
        	Toast.makeText(context, "Fail To Save The Screenshot!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
        	Toast.makeText(context, "Fail To Save The Screenshot!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
 
        // insert the picture into the system gallery
        try 
        {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), picturefile.getAbsolutePath(), pictureName, "BakeAngry's Screenshot");
            Toast.makeText(context, "Successfully Saved!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
        	Toast.makeText(context, "Fail To Save The Screenshot!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        // inform the gallery to refresh
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse(picturefile.getAbsolutePath())));
        return Uri.parse(picturefile.getAbsolutePath());
    }
	
	public static Bitmap takeScreenShot(Activity activity)
	{
		View screenView = activity.getWindow().getDecorView();
		screenView.setDrawingCacheEnabled(true);
		screenView.buildDrawingCache();
		Bitmap screenBitmap = Bitmap.createBitmap(screenView.getDrawingCache());
		
		int screenWidth = screenView.getWidth();
		int screenHeight = screenView.getHeight();
		Rect frame = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		int frameHeight = frame.top;
		Bitmap screenShot = Bitmap.createBitmap(screenBitmap, 0, frameHeight, screenWidth, screenHeight - frameHeight);

		return screenShot;
	}
	
	public static void SaveScreenShot(Activity activity)
	{
		Bitmap target;
		target = takeScreenShot(activity);
		saveImageToGallery(activity, target);
	}
}
