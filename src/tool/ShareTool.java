package tool;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

public class ShareTool 
{
	public static void ShareToWechat(Activity activity, Bitmap bmp)
	{
		Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(activity.getContentResolver(), bmp, null,null));
		Intent shareIntent = new Intent();
		ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
		shareIntent.setComponent(comp);
		shareIntent.setAction(Intent.ACTION_SEND);
		shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
		shareIntent.setType("image/*");
		activity.startActivity(Intent.createChooser(shareIntent, "∑÷œÌÕº∆¨"));
	}
	
	public static void ShareToWechatTimeLine(Activity activity, Bitmap bmp)
	{
		Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(activity.getContentResolver(), bmp, null,null));
		Intent shareIntent = new Intent();
		ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
		shareIntent.setComponent(comp);
		shareIntent.setAction(Intent.ACTION_SEND);
		shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
		shareIntent.setType("image/*");
		activity.startActivity(Intent.createChooser(shareIntent, "∑÷œÌÕº∆¨"));
	}
	
	public static void ShareToQQ(Activity activity, Bitmap bmp)
	{
		Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(activity.getContentResolver(), bmp, null,null));
		Intent shareIntent = new Intent();
		ComponentName comp = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity");
		shareIntent.setComponent(comp);
		shareIntent.setAction(Intent.ACTION_SEND);
		shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
		shareIntent.setType("image/*");
		activity.startActivity(Intent.createChooser(shareIntent, "∑÷œÌÕº∆¨"));
	}
}
