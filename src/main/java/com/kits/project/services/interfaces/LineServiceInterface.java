package com.kits.project.services.interfaces;


import com.kits.project.DTOs.LineDTO;
import com.kits.project.DTOs.MapLinesDTO;
import com.kits.project.model.Line;
import com.kits.project.model.Station;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public interface LineServiceInterface {

    public Line addNewLine(LineDTO line);

    public List<Line> getAllLines();

    public ArrayList<MapLinesDTO> getLinesForMap();

    public ArrayList<Station> getStationForLine(Long lineID);

    public boolean deleteLine(long id);

    public Line updateLine(Long lineID, LineDTO lineDTO);


    public Line addStation(Long lineID, Long stationID);


    public Line addTimeSchedule(Long lineID, Long scheduleID);


    public Line addTicket(Long lineID, Long ticketID);


    public boolean archiveLine(Long lineID);
}
