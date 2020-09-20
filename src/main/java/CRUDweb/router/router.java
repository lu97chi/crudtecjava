package CRUDweb.router;

import CRUDweb.controller.UserController;
import express.Express;
import express.ExpressRouter;
import express.middleware.Middleware;

public class router {

    public static void init() {
        UserController userController = new UserController();
        Express app = new Express() {{
            // Define home routes
            use("/users", new ExpressRouter(){{
              get("/all",  (req, res) -> userController.getAll(req, res));
              get("/:rfc", (req, res) -> userController.getUserByRfc(req, res));
              post("/:rfc", (req, res) -> userController.delete(req, res));
              post("/update/:rfc", (req, res) -> userController.update(req, res));
              post("/", (req, res) -> userController.create(req, res));
            }});
        }};
        app.use(Middleware.cors());
        app.listen();
    }
}
