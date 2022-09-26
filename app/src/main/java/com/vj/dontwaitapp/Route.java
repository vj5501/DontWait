package com.vj.dontwaitapp;

public class Route {
    Long  BusNo;
    String Source,Destination,LeavingTime;

    public Route(){}

    public Route(Long busNo, String source, String destination, String leavingTime) {
        BusNo = busNo;
        Source = source;
        Destination = destination;
        LeavingTime = leavingTime;
    }

    public Long getBusNo() {
        return BusNo;
    }

    public void setBusNo(Long busNo) {
        BusNo = busNo;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getLeavingTime() {
        return LeavingTime;
    }

    public void setLeavingTime(String leavingTime) {
        LeavingTime = leavingTime;
    }
}
