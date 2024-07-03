<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>URL Shortener</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 2em;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: center;
        }
        h1 {
            color: #333;
        }
        label {
            display: block;
            margin-bottom: 0.5em;
            color: #555;
        }
        input[type="text"] {
            width: calc(100% - 1em);
            padding: 0.5em;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-bottom: 1em;
            font-size: 1em;
        }
        button {
            padding: 0.5em 1em;
            background-color: #007bff;
            border: none;
            color: white;
            border-radius: 4px;
            font-size: 1em;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .result {
            margin-top: 1em;
            padding: 1em;
            background-color: #e9ffe9;
            border: 1px solid #b3ffb3;
            border-radius: 4px;
            color: #333;
        }
        .result a {
            color: #007bff;
            text-decoration: none;
        }
        .result a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>URL Shortener</h1>
        <form action="/shorten" method="post">
            <label for="longUrl">Enter a long URL:</label>
            <input type="text" id="longUrl" name="longUrl" required>
            <button type="submit">Shorten</button>
        </form>

        <#-- Check if the shortUrl is available and display it -->
        <#if shortUrl??>
            <div class="result">
                <h2>Shortened URL:</h2>
                <p><a href="${shortUrl}" target="_blank">${shortUrl}</a></p>
            </div>
        </#if>
    </div>
</body>
</html>
