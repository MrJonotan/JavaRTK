package Homework4;

import java.util.HashMap;

public class TV {
    protected String brand;
    protected String model;
    protected int diagonal;
    protected boolean smartTV;
    public boolean powerOn;
    private int channel;
    private int currentVolume;

    // метод конструктора класса TV
    public TV(String brand, String model, int diagonal, boolean smartTV) {
        this.brand = brand;
        this.model = model;
        this.diagonal = diagonal;
        this.smartTV = smartTV;
        this.powerOn = true;
        this.currentVolume = 10;
    }

    public static String getTVName(TV device){
        return device.brand + " " + device.model;
    }

    public static String getInfo(TV device){
        return "Brand: " + device.brand + "\r\nModel: " + device.model + "\r\nDiagonal: " + device.diagonal + "\"" + "\r\nSmartTV: " + device.smartTV;
    }

    public String power () {
        if(!powerOn){
            powerOn = true;
            return "TV is on \r";
        }else{
            powerOn = false;
            return "TV is off \r";
        }
    }

    public String changeChannel (String command){
        try {
            int button = Integer.parseInt(command);
            if(powerOn && this.channel != button){
                this.channel = button;
                return checkChannelList(button) + "\r";
            }else if(powerOn){
                return "You are already watching this channel! \r";
            }else{
                power();
                changeChannel(command);
            };
        }catch (NumberFormatException e){
            return e.getMessage();
        }
        return command;
    }

    public String changeVolume (String change){
        if(this.currentVolume >= 0 && this.currentVolume <= 100){
            if(change.equals("+")){
                this.currentVolume++;
            }else{
                this.currentVolume--;
            }
        }
        return  "Volume: " + this.currentVolume;
    }

    private String checkChannelList(int channelNumber){
        HashMap<Integer, String> channelList = new HashMap<>();
        channelList.put(1, "Первый канал");
        channelList.put(2, "Россия");
        channelList.put(3, "Матч ТВ!");
        channelList.put(4, "ТВЦ");
        channelList.put(5, "НТВ");
        channelList.put(6, "СТС");
        channelList.put(7, "5 канал");
        channelList.put(8, "Карусель");
        channelList.put(9, "РЕН ТВ");
        channelList.put(10, "ТНТ");
        if(channelList.containsKey(channelNumber)){
            return "Channel changed to: " + channelList.get(channelNumber);
        }else{
            return "Sorry, channel not found. It's time to buy an extended subscription!";
        }
    }
}
