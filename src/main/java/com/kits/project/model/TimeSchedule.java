package com.kits.project.model;

import com.kits.project.DTOs.TimeScheduleDTO;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Lupus on 10/30/2018.
 */
@Entity
public class TimeSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "line")
    private Line line;

    @Column(name = "time")
    private Time time;

    @Column(name = "station")
    private Station station;

    public TimeSchedule() { }

    public TimeSchedule(Line line, Time time, Station station) {
        this.line = line;
        this.time = time;
        this.station = station;
    }

    public TimeSchedule(TimeScheduleDTO timeScheduleDTO) {
        this.line = null;
        this.time = null;
        this.station = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
