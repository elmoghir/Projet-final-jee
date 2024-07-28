import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {CustomerService} from "../services/customer.service";
import {catchError, Observable, throwError} from "rxjs";
import {CustomerModel} from "../model/customer.model";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-customers',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    JsonPipe,
    AsyncPipe,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  customers!: Observable<Array<CustomerModel>>;
  errorMessage!: String;
  searchFormGroup: FormGroup | undefined;
  constructor(private customerService: CustomerService, private fb: FormBuilder) {
  }
  ngOnInit() {
    this.searchFormGroup = this.fb.group({
      keyword : this.fb.control("")
    });
    this.handleSearchCustomers();
  }

  handleSearchCustomers() {
     let kw = this.searchFormGroup?.value.keyword;
     this.customers = this.customerService.searchCustomers(kw).pipe(
       catchError(err => {
         this.errorMessage=err.message;
         return throwError(err);
       })
     );
  }
}
