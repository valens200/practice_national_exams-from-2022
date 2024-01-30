import express, { Express, Request, Response, Application } from "express";
import dotenv from "dotenv";
const connection = require("../backend/src/database/squalizer");

const init = require("../backend/src/models/User");

dotenv.config();

const app: Application = express();
const port = process.env.PORT || 8000;

app.get("/", (req: Request, res: Response) => {
  res.send("Welcome to Express & TypeScript Server");
});

app.listen(port, () => {
  console.log(`Server is Fire at http://localhost:${port}`);
});
