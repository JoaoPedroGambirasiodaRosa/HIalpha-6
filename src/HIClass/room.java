/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HIClass;

/**
 *
 * @author s.lucas
 */
public class room {

   private int pkIdRoom;
   private String room;
   private String locall;
   private String floor;

    public int getPkIdRoom() {
        return pkIdRoom;
    }

    public void setPkIdRoom(int pkIdRoom) {
        this.pkIdRoom = pkIdRoom;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getLocall() {
        return locall;
    }

    public void setLocall(String locall) {
        this.locall = locall;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "room{" + "pkIdRoom=" + pkIdRoom + ", room=" + room + ", locall=" + locall + ", floor=" + floor + '}';
    }
    
 }

    
    

