import bcomp.HomeController

class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/leaderboard"(controller: 'leaderboard', action: 'view')

        "/"(controller: 'home', action: 'home')

        "/foundation"(view:'/foundation')


        "/status"(view:"/index")
        "500"(view:'/error')
	}
}
