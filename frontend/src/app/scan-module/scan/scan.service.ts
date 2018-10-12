import { Injectable } from "@angular/core";
import { Http } from "@angular/http";
import { Observable } from 'rxjs';
import { TicketAndCheckInResult } from './scan-common';
import { Account } from "../account/account";

@Injectable()
export class ScanService {
    constructor(private http: Http) {
    }

    public checkIn(eventKey: string, account: Account, scan: string): Observable<TicketAndCheckInResult> {
        return this.performCheckIn(account, `${account.url}/admin/api/check-in/event/${eventKey}/ticket/${scan}`, scan);
    }

    public forcePrintLabel(eventKey: string, account: Account, scan: string) {
        let url = `${account.url}/admin/api/check-in/event/${eventKey}/force-print-label-ticket/${scan}`;
        return this.http.post(url, {"code" : scan});
    }

    public confirmPayment(eventKey: string, account: Account, scan: string): Observable<TicketAndCheckInResult> {
        return this.performCheckIn(account, `${account.url}/admin/api/check-in/event/${eventKey}/ticket/${scan}/confirm-on-site-payment`, scan);
    }

    private performCheckIn(account: Account, url: string, scan: string): Observable<TicketAndCheckInResult> {
        return this.http.post(url, {"code": scan}).map(r => r.json());
    }
}
