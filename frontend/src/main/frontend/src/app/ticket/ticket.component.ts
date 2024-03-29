import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogConfig} from '@angular/material';
import {Router} from '@angular/router';
import {TicketsService} from '../services/tickets.service';
import {TimeScheduleService} from '../services/time-schedule-service.service';
import {TimeScheduleItemModel} from '../models/timeScheduleItem.model';
import {AddDepartureDialogComponent} from '../timetable/add-departure-dialog/add-departure-dialog.component';
import {ListExistingDeparturesDialogComponent} from '../timetable/list-existing-departures-dialog/list-existing-departures-dialog.component';
import {Departure} from '../models/departure';
import {Ticket} from '../models/ticket';
import {ListOwnedTicketsDialogComponent} from './list-owned-tickets-dialog/list-owned-tickets-dialog';
import {PricelistService} from "../services/pricelist-service.service";
import {JwtService} from "../services/auth/jwt.service";
import * as _ from 'lodash';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  selectedOption: string;
  ticketPrices = [];
  selectedPrice = 0;
  options = [];
  currentUserTickets;
  userName = "";

  constructor(private dialog: MatDialog,
              private router: Router,
              private ticketService: TicketsService,
              private pricelistService: PricelistService,
              protected jwtService: JwtService) {

  }


  ngOnInit() {
    this.pricelistService.getCurrentPricelist()
      .then(response => {
        this.ticketPrices = _.map(response, (item) => {
          return {type:item.ticketType, price: item.price};
        })
        this.options = _.map(response, (item) => {
          if (item.ticketType === 'SINGLE') {
              return {name: "One Use", value: "One Use"};
          } else if (item.ticketType === 'MONTHLY') {
              return {name: "Monthly", value: "Monthly"};
          } else if (item.ticketType === 'YEARLY') {
              return { name: "Yearly", value: "Yearly" };
          }
        })
        console.log(response[0].price);
        this.selectedOption = this.options[0].name || "";
        this.selectedPrice = response[0].price !== null ? response[0].price : 0;
      });
  }
  onChange($event) {
    if(this.selectedOption == "One Use") {
      this.selectedPrice = _.find(this.ticketPrices, {type:'SINGLE'}).price;
    } else if (this.selectedOption == "Monthly"){
      this.selectedPrice = _.find(this.ticketPrices, {type:'MONTHLY'}).price;
    } else if (this.selectedOption == "Yearly") {
      this.selectedPrice =_.find(this.ticketPrices, {type:'YEARLY'}).price;
    }
  }
  openOwnedTicketsDialog(): void {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = false;
    dialogConfig.autoFocus = true;

    dialogConfig.data = {
      token: localStorage.getItem('Authentication-Token')
    };

    this.dialog.open(ListOwnedTicketsDialogComponent, dialogConfig);
  }

  buyTicket() {
    if(this.selectedOption == "One Use") {
      this.buyOneWayTicket();
    } else if (this.selectedOption == "Monthly"){
      this.buyMonthlyTicket();
    } else if (this.selectedOption == "Yearly") {
      this.buyYearlyTicket();
    } else {
      alert("Something went wrong");
    }
  }

  buyOneWayTicket() {
    var ticket: Ticket = new Ticket(localStorage.getItem('Authentication-Token'), "oneUse", null, null, null, false);
    ticket.price = this.selectedPrice;
    this.ticketService.buyOneWayTicket(ticket)
    .then(response => {
        alert("One-way ticket successfully bought! ");
      });
  }

  buyMonthlyTicket() {
    var ticket: Ticket = new Ticket(localStorage.getItem('Authentication-Token'), "monthly", null, null, null, false);
    ticket.price = this.selectedPrice;
    this.ticketService.buyMultipleUseTicket(ticket)
      .then(response => {
        alert("Monthly ticket successfully bought! ");
      });
  }

  buyYearlyTicket() {
    var ticket: Ticket = new Ticket(localStorage.getItem('Authentication-Token'), "yearly", null, null, null, false);
    ticket.price = this.selectedPrice;
    this.ticketService.buyMultipleUseTicket(ticket)
      .then(response => {
        alert("Yearly ticket successfully bought! ");
      });
  }

  checkUserActiveTickets() {
    console.log(this.userName);
    this.ticketService.getUserActiveTickets(this.userName)
      .then((response) => {
        this.currentUserTickets = response;
        if(!response || response===[] ){
          alert("User not found!")
        }
      });
  }

}
