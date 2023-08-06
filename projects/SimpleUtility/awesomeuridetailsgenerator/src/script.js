document.addEventListener("DOMContentLoaded", function () {
  const inputDataTextarea = document.getElementById("inputData");
  const outputDataTextarea = document.getElementById("outputData");
  const exchangeButton = document.getElementById("exchangeButton");
  let isInputJson = true;

  exchangeButton.addEventListener("click", () => {
    isInputJson = !isInputJson;
    if (isInputJson) {
      block1.style.display = "block";
      block2.style.display = "block";
      block1Header.textContent = "Input JSON Config";
      block2Header.textContent = "Generated URI";
      let temp = inputDataTextarea.textContent;
      inputDataTextarea.textContent = outputDataTextarea.textContent;
      outputDataTextarea.textContent = temp;
      inputDataTextarea.removeEventListener("input", parseJSONConfig);
      inputDataTextarea.addEventListener("input", generateURI);
    } else {
      block1.style.display = "block";
      block2.style.display = "block";
      block1Header.textContent = "Input URI";
      block2Header.textContent = "Generated JSON Config";
      let temp = inputDataTextarea.textContent;
      inputDataTextarea.textContent = outputDataTextarea.textContent;
      outputDataTextarea.textContent = temp;
      inputDataTextarea.removeEventListener("input", generateURI);
      inputDataTextarea.addEventListener("input", parseJSONConfig);
    }
  });

  function generateURI() {
    try {
      const jsonConfig = JSON.parse(inputDataTextarea.textContent);
      const { scheme, host, port, pathSegment, queryParam, fragment } = jsonConfig;

      const queryString = Object.entries(queryParam)
        .map(([key, value]) => {
          if (Array.isArray(value)) {
            return value.map(val => `${encodeURIComponent(key)}=${encodeURIComponent(val)}`).join("&");
          }
          return `${encodeURIComponent(key)}=${encodeURIComponent(value)}`;
        })
        .join("&");

      const uri = `${scheme}://${host}${port ? `:${port}` : ""}/${pathSegment.join("/")}${queryString ? `?${queryString}` : ""}${fragment ? `#${fragment}` : ""}`;

      outputDataTextarea.textContent = uri;
    } catch (error) {
      outputDataTextarea.textContent = "Error: Invalid JSON config";
    }
  }

  function parseJSONConfig() {
    try {
      const uri = inputDataTextarea.textContent;
      const parser = document.createElement("a");
      parser.href = uri;

      const jsonConfig = {
        "scheme": parser.protocol.replace(":", ""),
        "host": parser.hostname,
        "port": parser.port,
        "pathSegment": parser.pathname.slice(1).split("/"),
        "queryParam": {},
        "fragment": parser.hash.slice(1)
      };

      const queryParamString = parser.search.slice(1);
      if (queryParamString) {
        const queryParams = queryParamString.split("&");
        for (const param of queryParams) {
          const [key, value] = param.split("=");
          if (key && value) {
            const decodedKey = decodeURIComponent(key);
            const decodedValue = decodeURIComponent(value);
            if (!jsonConfig.queryParam.hasOwnProperty(decodedKey)) {
              jsonConfig.queryParam[decodedKey] = decodedValue;
            } else {
              if (Array.isArray(jsonConfig.queryParam[decodedKey])) {
                jsonConfig.queryParam[decodedKey].push(decodedValue);
              } else {
                jsonConfig.queryParam[decodedKey] = [jsonConfig.queryParam[decodedKey], decodedValue];
              }
            }
          }
        }
      }

      outputDataTextarea.textContent = JSON.stringify(jsonConfig, null, 2);
    } catch (error) {
      outputDataTextarea.textContent = "Error: Invalid URI";
    }
  }
  inputDataTextarea.addEventListener("input", generateURI);
  generateURI();
});
