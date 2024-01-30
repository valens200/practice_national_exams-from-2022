const { Sequelize } = require("sequelize");
const config = require("./configg"); //path to the above config.js file
const sequelize = new Sequelize(config.development);
async function connectDB() {
  try {
    await sequelize.authenticate();
    console.log("Database connected succefully");
  } catch (error) {
    console.error("Unable to connect to the database:", error);
  }
}
connectDB();

module.exports = sequelize;
