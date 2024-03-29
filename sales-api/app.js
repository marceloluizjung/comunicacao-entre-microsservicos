import express from "express";

import { connectMongoDb } from "./src/config/db/mongoDbConfig.js";
import { createInitialData } from "./src/config/db/initialData.js";
import { connectRabbitMq } from "./src/config/rabbitmq/rabbitConfig.js"; 
import checkToken from "./src/config/auth/CheckToken.js";

const app = express();
const env = process.env;
const PORT = env.PORT || 8082;

connectMongoDb();
connectRabbitMq();
createInitialData();

app.use(checkToken);

app.get("/api/status", async (req, res) => {
    return res.status(200).json(
        {
            service: "Sales-Api",
            status: "up",
            httpStatus: 200
        }
    );
});

app.listen(PORT, () => {
    console.info(`Server started successfully at port ${PORT}`);
});