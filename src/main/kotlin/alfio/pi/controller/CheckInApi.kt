/*
 * This file is part of alf.io.
 *
 * alf.io is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * alf.io is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with alf.io.  If not, see <http://www.gnu.org/licenses/>.
 */

package alfio.pi.controller

import alfio.pi.model.CheckInResponse
import alfio.pi.model.CheckInResult
import alfio.pi.model.EmptyTicketResult
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/check-in")
open class CheckInApi {

    @RequestMapping(value = "/{eventId}/ticket/{ticketIdentifier}", method = arrayOf(RequestMethod.POST))
    open fun performCheckIn(@PathVariable("eventId") eventId: Int, @PathVariable("ticketIdentifier") ticketIdentifier: String, @RequestBody ticketCode: TicketCode): CheckInResponse {
        return EmptyTicketResult(CheckInResult())
    }

    class TicketCode {
        var code: String? = null
    }
}