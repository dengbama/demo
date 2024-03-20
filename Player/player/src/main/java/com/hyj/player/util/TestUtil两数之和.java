package com.hyj.player.util;

import com.hyj.player.service.TestService;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;


/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：TestUtil
 * @Date：2023/12/29 16:13
 */
public class TestUtil两数之和 {

    private static DataLine.Info info = null;
    private static AudioFormat format = null;
    private static SourceDataLine line = null;
    private static AudioInputStream audio = null;

    public static void main(String[] args) {
        //加载音频
//        String musiPath="I:\\m\\西楼-孩子.mp3";
//        getMusic(musiPath);
//        String o1="11111";
//        TestService testService=("")->System.out.println("sout");
//        System.out.println("------------");
//        testService.test();
        System.out.print("nums = ");
        String s = new Scanner(System.in).nextLine();
        System.out.print("target = ");
        Scanner scanNum=new Scanner(System.in);
        boolean b = scanNum.hasNextInt();
        if (!b){
            System.out.println("输入数值总和");
            return;
        }
        String[] split = s.trim().replace("[","").replace("]","").
                replace(" ","").split(",");
        int[]array=new int[split.length];
        for (int i = 0; i < array.length; i++) {
            try {
                int i1 = Integer.parseInt(split[i]);
                array[i]=i1;
            }catch (Exception e){
                System.out.println(split[i]+"转换为数字失败");
            }
        }
        int num = scanNum.nextInt();
        //方法一
//        test1(array,num);
        //方法二
        test2(array,num);
    }

    private static void test2(int[] array, int num){
        Map<Integer, Integer>map=new HashMap<>();
        int[]result=null;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                result=new int[]{map.get(array[i]),i};
                break;
            }else {
                int a=num-array[i];
                map.put(a,i);
            }
        }

        if (null==result){
            System.out.println("xxxxxxxxxxxxxx");
        }else {
            System.out.println(Arrays.toString(result));
        }

    }


    private static void test1(int[] array, int num){
        boolean bool=false;
        int[]result=null;
        for (int i = 0; i < array.length-1; i++) {
            int i1 = array[i];
            int a=0;
            for (int j = i+1; j < array.length; j++) {
                int i2 = array[j];
                if (num==i1+i2){
                    a=j;
                    bool=true;
                    break;
                }
            }
            if (bool){
                result=new int[]{i,a};
                break;
            }
        }
        if (null==result){
            System.out.println("xxxxxxxxxxxxxx");
        }else {
            System.out.println(Arrays.toString(result));
        }
    }


    //获取音乐
    private static void getMusic(String musiPath){
        File file=new File(musiPath);
        MpegAudioFileReader reader=new MpegAudioFileReader();
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = reader.getAudioInputStream(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (audioInputStream==null){
            return;
        }

        try {
            format = audioInputStream.getFormat();
            geiInfo(format,audioInputStream);
            format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format.getSampleRate(), 16, format.getChannels(),
                    format.getChannels() * 2, format.getSampleRate(), false);
            audio = AudioSystem.getAudioInputStream(format, audioInputStream);
            info = new DataLine.Info(SourceDataLine.class, format, AudioSystem.NOT_SPECIFIED);
            line = (SourceDataLine) AudioSystem.getLine(info);

            line.open(format);
            line.start();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = audio.read(buffer)) > 0) {
                line.write(buffer, 0, len);
            }
            line.drain();
            line.stop();
            line.close();
            audio.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //获取音乐详细信息
    private static void geiInfo(AudioFormat format,AudioInputStream audioInputStream){
        //播放时长
        String s = format.toString();
        System.out.println(s);
        System.out.println("音频总帧数："+audioInputStream.getFrameLength());
        System.out.println("每秒播放帧数："+format.getSampleRate());
        float len = audioInputStream.getFrameLength()/format.getSampleRate();
        System.out.println("音频时长（秒）："+len);
        System.out.println("音频时长："+(int)len/60+"分"+(int)len%60+"秒");
    }



}
